const axios = require('axios');
const { formatWaktu, formatNomorHp } = require('./helpersKlinikController');
require('dotenv').config();

async function cariKlinik(req, res) {
  try {
    const { latitude, longitude } = req.query;
    const API_KEY = process.env.GOOGLE_MAPS_API_KEY;

    // Membuat URL untuk mengakses Google Maps Places API
    const url = `https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=${latitude},${longitude}&radius=5000&keyword=klinik%20kecantikan&key=${API_KEY}`;

    // Mengirim permintaan HTTP GET ke Google Maps Places API
    const response = await axios.get(url);
    const results = response.data.results;

    // Mengambil informasi yang diperlukan dari hasil pencarian
    const klinikPromises = results.map(async (place) => {
      const photoUrl = place.photos
        ? `https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=${place.photos[0].photo_reference}&key=${API_KEY}`
        : '';

      // Mengambil jarak dari titik lokasi pengguna ke tempat klinik menggunakan Distance Matrix API
      const distanceUrl = `https://maps.googleapis.com/maps/api/distancematrix/json?units=metric&origins=${latitude},${longitude}&destinations=${place.geometry.location.lat},${place.geometry.location.lng}&key=${API_KEY}`;
      const distanceResponse = await axios.get(distanceUrl);
      const distance = distanceResponse.data.rows[0].elements[0].distance.text;

      // Mengambil detail tempat untuk mendapatkan jam buka, tutup, dan nomor telepon
      const detailUrl = `https://maps.googleapis.com/maps/api/place/details/json?place_id=${place.place_id}&fields=name,formatted_address,rating,photos,opening_hours,formatted_phone_number&key=${API_KEY}`;
      const detailResponse = await axios.get(detailUrl);
      const detailResult = detailResponse.data.result;
      const openingHours = detailResult.opening_hours;
      const phoneNumber = detailResult.formatted_phone_number || 'Belum Tersedia';

      let jamBuka = '';
      let jamTutup = '';

      if (openingHours && openingHours.periods && openingHours.periods.length > 0) {
        const period = openingHours.periods[0];
        jamBuka = period.open && period.open.time ? formatWaktu(period.open.time) : '';
        jamTutup = period.close && period.close.time ? formatWaktu(period.close.time) : '';
      }

      const nomorHp = place.international_phone_number || '';
      const whatsappUrl = formatNomorHp(nomorHp);

      return {
        nama: place.name,
        alamat: place.vicinity,
        rating: place.rating,
        fotoUrl: photoUrl,
        jarak: distance,
        jamBuka,
        jamTutup,
        nomorHP: phoneNumber,
        whatsappUrl: formatNomorHp(phoneNumber),
      };
    });

    // Menunggu semua promise untuk menyelesaikan dan mengembalikan hasil
    const klinik = await Promise.all(klinikPromises);

    res.json({ klinik });
  } catch (error) {
    console.error('Terjadi kesalahan:', error);
    res.status(500).json({ error: 'Terjadi kesalahan saat mencari klinik kecantikan.' });
  }
}


async function cariKlinikDenganKeyword(req, res){
  try {
    const { keyword } = req.query;
    const API_KEY = process.env.GOOGLE_MAPS_API_KEY;

    // Membuat URL untuk mengakses Google Maps Places API dengan keyword pencarian
    const url = `https://maps.googleapis.com/maps/api/place/textsearch/json?query=${encodeURIComponent(
      keyword
    )}&type=beauty_salon&key=${API_KEY}`;

    // Mengirim permintaan HTTP GET ke Google Maps Places API
    const response = await axios.get(url);
    const results = response.data.results;

    // Mengambil informasi yang diperlukan dari hasil pencarian
    const klinikPromises = results.map(async (place) => {
      const photoUrl = place.photos
        ? `https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=${place.photos[0].photo_reference}&key=${API_KEY}`
        : '';

      // Mengambil detail tempat untuk mendapatkan jam buka, tutup, dan nomor telepon
      const detailUrl = `https://maps.googleapis.com/maps/api/place/details/json?place_id=${place.place_id}&fields=name,formatted_address,rating,photos,opening_hours,formatted_phone_number&key=${API_KEY}`;
      const detailResponse = await axios.get(detailUrl);
      const detailResult = detailResponse.data.result;
      const openingHours = detailResult.opening_hours;
      const phoneNumber = detailResult.formatted_phone_number || 'Belum Tersedia';

      let jamBuka = '';
      let jamTutup = '';

      if (openingHours && openingHours.periods && openingHours.periods.length > 0) {
        const period = openingHours.periods[0];
        jamBuka = period.open && period.open.time ? formatWaktu(period.open.time) : '';
        jamTutup = period.close && period.close.time ? formatWaktu(period.close.time) : '';
      }

      const nomorHp = place.international_phone_number || '';
      const whatsappUrl = formatNomorHp(nomorHp);

      return {
        nama: place.name,
        alamat: place.formatted_address,
        rating: place.rating,
        fotoUrl: photoUrl,
        jamBuka,
        jamTutup,
        nomorHP: phoneNumber,
        whatsappUrl: formatNomorHp(phoneNumber),
      };
    });

    // Menunggu semua promise untuk menyelesaikan dan mengembalikan hasil
    const klinik = await Promise.all(klinikPromises);

    res.json({ klinik });
  } catch (error) {
    console.error('Terjadi kesalahan:', error);
    res.status(500).json({ error: 'Terjadi kesalahan saat mencari klinik kecantikan.' });
  }
};

module.exports = { cariKlinik, cariKlinikDenganKeyword };