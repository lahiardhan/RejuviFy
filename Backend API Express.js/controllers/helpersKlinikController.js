function formatWaktu(waktu) {
    const [jam, menit] = waktu.split(':');
    const jamFormatted = jam ? (jam.length === 1 ? `0${jam}` : jam) : '';
    const menitFormatted = menit ? (menit.length === 1 ? `0${menit}` : menit) : '';
  
    if (!jamFormatted && !menitFormatted) {
      return 'Belum Tersedia';
    } else if (!jamFormatted) {
      return 'Tutup';
    } else {
      const time = new Date();
      time.setHours(jamFormatted);
      time.setMinutes(menitFormatted);
      return time.toLocaleTimeString('id-ID', { hour12: false }).slice(0, -3);
    }
  }
  
  function formatNomorHp(phoneNumber) {
    if (phoneNumber && phoneNumber !== 'Belum Tersedia') {
      const formattedNumber = phoneNumber.replace(/[\s()-]/g, ''); // Menghapus spasi dalam nomor HP
      const nomorHpWithCountryCode = formattedNumber.startsWith('0') ? `+62${formattedNumber.substr(1)}` : formattedNumber;
      return `https://api.whatsapp.com/send?phone=${encodeURIComponent(nomorHpWithCountryCode)}`;
    } else {
      return null; // Mengembalikan null jika nomor HP tidak tersedia
    }
  }
  
  module.exports = { formatWaktu, formatNomorHp };  