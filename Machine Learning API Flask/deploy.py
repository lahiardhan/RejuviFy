from flask import Flask, request, jsonify
import numpy as np
from tensorflow.keras.models import load_model
import tensorflow_hub as hub
from PIL import Image
from google.cloud import storage
import mysql.connector
import os
from datetime import datetime
from jwt.exceptions import ExpiredSignatureError, InvalidTokenError
import jwt
from functools import wraps
import random

app = Flask(__name__)

keyfile_path = os.path.join(os.path.dirname(__file__), 'keyfile.json')
client = storage.Client.from_service_account_json(keyfile_path)

# Predicting Images
model = load_model('model.h5', compile=False, custom_objects={'KerasLayer': hub.KerasLayer})
labels = ["acne", "blackhead", "wrinkles", "enlarged-pores", "redness", "dark-spot"]

# Fungsi untuk menghubungkan ke database MySQL
def get_mysql_connection():
    return mysql.connector.connect(
        host='34.101.84.186',
        user='root',
        password='password',
        database='skintastic'
    )


def authenticate_user(f):
    @wraps(f)
    def decorated_function(*args, **kwargs):
        token = request.headers.get('Authorization')
        if token is None:
            return jsonify({'error': 'Unauthorized'}), 401

        try:
            # Decode dan verifikasi token JWT
            decoded_token = jwt.decode(token.split(' ')[1], 'mysecret', algorithms=['HS256'])
            # Peroleh id_user dari token
            id_user = decoded_token['rows'][0]['id_user']

            # Tambahkan id_user ke objek permintaan (request object)
            request.id_user = id_user
        except jwt.ExpiredSignatureError:
            return jsonify({'error': 'Expired token'}), 401
        except (jwt.DecodeError, jwt.InvalidTokenError):
            return jsonify({'error': 'Invalid token'}), 401

        return f(*args, **kwargs)

    return decorated_function

@app.route('/')
def home():
    message = "Welcome to our Rejuvify machine learning model endpoints. Before accessing our ML endpoints, please first register and login."
    return jsonify(message)


@app.route('/predict', methods=['POST'])
@authenticate_user
def predict():
    # Mengambil ID pengguna dari permintaan
    user_id = request.id_user

    # Menginisialisasi daftar prediksi gambar
    predictions = []

    for i in range(1, 5):  # Mengulangi untuk file1, file2, file3, file4
        file_key = f'file{i}'

        if file_key not in request.files:
            return jsonify({'error': f'No {file_key} provided'}), 400

        file = request.files[file_key]
        image = Image.open(file)

        # Memastikan kedalaman gambar yang tepat
        if image.mode != 'RGB':
            image = image.convert('RGB')

        image = image.resize((224, 224))
        image = np.array(image) / 255.0
        image = np.expand_dims(image, axis=0)
        images = np.vstack([image])

        # Melakukan prediksi gambar menggunakan model
        prediction = model.predict(images)[0]

        predicted_labels = []
        for j, pred in enumerate(prediction):
            predicted_labels.append({'label': labels[j], 'accuracy': float(pred)})

        # Menambahkan hasil prediksi ke daftar prediksi
        predictions.append(predicted_labels)

    # Generate unique filename using timestamp and user ID
    timestamp = datetime.now().strftime('%Y-%m-%d_%H%M%S')
    unique_filename = f"image_{timestamp}_{user_id}.jpg"

    # Upload gambar ke GCS
    bucket = client.bucket('skintastic-analyzed-images')
    blob = bucket.blob(unique_filename)
    file.seek(0)
    blob.upload_from_file(file)

    # Dapatkan URL gambar di GCS
    image_url = blob.public_url

    current_time = datetime.now()

    # Simpan URL gambar ke database MySQL dan peroleh id_image yang baru saja dimasukkan
    conn = get_mysql_connection()
    cursor = conn.cursor()
    cursor.execute('INSERT INTO image (id_userimage, image_url, date) VALUES (%s, %s, %s)', (user_id, image_url, current_time))
    conn.commit()

    # Peroleh id_image yang baru saja dimasukkan
    cursor.execute('SELECT LAST_INSERT_ID()')
    id_image = cursor.fetchone()[0]

    # Perbarui tabel skin_analyze dengan hasil analisis, id_image, dan date_analyze yang sesuai
    analyze_values = []
    for i in range(6):
        highest_accuracy = max(prediction[i]['accuracy'] for prediction in predictions)
        analyze_values.append(highest_accuracy)

    # Menentukan nilai skin_health berdasarkan aturan yang telah ditetapkan
    above_threshold = sum(value > 0.5 for value in analyze_values)

    if above_threshold == 0:
        skin_health = 100
    elif above_threshold == 1:
        skin_health = random.randint(90, 95)
    elif above_threshold == 2 or above_threshold == 3:
        skin_health = random.randint(85, 89)
    elif above_threshold == 4:
        skin_health = random.randint(80, 84)
    elif above_threshold == 5 or above_threshold == 6:
        skin_health = random.randint(75, 79)

    # Memasukkan hasil skin_health ke dalam tabel skin_analyze
    cursor.execute('INSERT INTO skin_analyze (id_useranalyze, id_imageanalyze, acne, blackhead, wrinkles, enlarged_pores, redness, darkspot, date_analyze, skin_health) '
                   'VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)',
                   (user_id, id_image, *analyze_values, current_time, skin_health))

    conn.commit()

    cursor.close()
    conn.close()

    # Membuat hasil analisis gambar dari model sebagai respons JSON
    prediction_results = {
        'date': current_time.strftime('%Y-%m-%d %H:%M:%S'),
        'image_url': image_url,
        'result_analyze': {
            'acne': max(prediction[0]['accuracy'] for prediction in predictions),
            'blackhead': max(prediction[1]['accuracy'] for prediction in predictions),
            'wrinkles': max(prediction[2]['accuracy'] for prediction in predictions),
            'enlarged_pores': max(prediction[3]['accuracy'] for prediction in predictions),
            'redness': max(prediction[4]['accuracy'] for prediction in predictions),
            'darkspot': max(prediction[5]['accuracy'] for prediction in predictions)
        },
        'skin_health': skin_health
    }

    # Mengembalikan respons JSON dengan hasil analisis gambar
    return jsonify(prediction_results)


@app.route('/history', methods=['GET'])
@authenticate_user  # Menambahkan decorator untuk autentikasi
def history():
    # Mengambil ID pengguna dari permintaan
    user_id = request.id_user

    # Menghubungkan ke database MySQL
    conn = get_mysql_connection()
    cursor = conn.cursor()

    # Mengambil riwayat analisis pengguna dari tabel skin_analyze
    cursor.execute('SELECT date_analyze, id_imageanalyze, acne, blackhead, wrinkles, enlarged_pores, redness, darkspot, skin_health '
                   'FROM skin_analyze '
                   'WHERE id_useranalyze = %s '
                   'ORDER BY date_analyze DESC', (user_id,))

    history_data = []
    for row in cursor.fetchall():
        analyze_date = row[0].strftime('%Y-%m-%d %H:%M:%S')
        image_id = row[1]
        acne = row[2]
        blackhead = row[3]
        wrinkles = row[4]
        enlarged_pores = row[5]
        redness = row[6]
        darkspot = row[7]
        skin_health = row[8]

        # Mengambil URL gambar analisis dari tabel image
        cursor.execute('SELECT image_url FROM image WHERE id_image = %s', (image_id,))
        image_url = cursor.fetchone()[0]

        # Menyusun data dalam format yang diinginkan
        history_item = {
            'date': analyze_date,
            'image_url': image_url,
            'result_analyze': {
                'acne': acne,
                'blackhead': blackhead,
                'wrinkles': wrinkles,
                'enlarged_pores': enlarged_pores,
                'redness': redness,
                'darkspot': darkspot
            },
            'skin_health': skin_health
        }

        history_data.append(history_item)

    cursor.close()
    conn.close()

    # Mengembalikan respons JSON dengan riwayat analisis pengguna
    return jsonify(history_data)


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=9000)
