# Menggunakan image Node.js versi 16.19.0 sebagai base image
FROM node:16.19.0

# Mengatur direktori kerja di dalam image
WORKDIR /app

# Menyalin package.json dan package-lock.json ke direktori kerja
COPY package*.json ./

# Menginstal dependensi aplikasi
RUN npm install

# Menyalin seluruh file ke direktori kerja
COPY . .

# Menjalankan perintah untuk menjalankan aplikasi
CMD [ "npm", "run", "start" ]
