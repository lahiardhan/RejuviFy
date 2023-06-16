// Import library yang diperlukan
const connection = require("../connect");
const mysql = require("mysql2");
const jwt = require("jsonwebtoken");
const config = require("../config/secret");

// Fungsi untuk menghapus akun pengguna
exports.deleteAccount = function (req, res) {
  const token = req.headers.authorization?.split(" ")[1]; // Mengambil token dari header Authorization

  if (!token) {
    return res.status(401).json({ error: true, message: "Token not provided" });
  }

  jwt.verify(token, config.secret, function (err, decoded) {
    if (err) {
      return res.status(401).json({ error: true, message: "Invalid token" });
    }

    var userId = decoded.rows[0].id_user; // Mendapatkan ID pengguna dari token JWT

    // Hapus akun pengguna dari database
    var query = "DELETE FROM user WHERE ?? = ?";
    var values = ["id_user", userId];

    query = mysql.format(query, values);
    connection.query(query, function (error, result) {
      if (error) {
        console.log(error);
        return res.status(500).json({ error: true, message: "Database error" });
      }

      // Hapus juga token autentikasi yang terkait dengan pengguna
      query = "DELETE FROM auth_tokens WHERE ?? = ?";
      values = ["id_usertoken", userId];
      connection.query(query, values, function (error, result) {
        if (error) {
          console.log(error);
          return res.status(500).json({ error: true, message: "Database error" });
        }

        return res.status(200).json({ success: true, message: "Account deleted successfully" });
      });
    });
  });
};
