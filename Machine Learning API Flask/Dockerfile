# Gunakan image Python versi 3.10.11
FROM python:3.10.11

# Set working directory di dalam container
WORKDIR /app

# Salin file requirements.txt ke dalam container
COPY requirements.txt .

# Install dependencies menggunakan pip
RUN pip install --no-cache-dir -r requirements.txt

# Salin kode aplikasi Flask ke dalam container
COPY . .

# Jalankan aplikasi Flask ketika container dijalankan
CMD ["python", "deploy.py"]