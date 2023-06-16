const jwt = require("jsonwebtoken");
const config = require("../config/secret");
const connection = require("../connect");
const mysql = require("mysql2");

// Middleware untuk memeriksa kevalidan token JWT
exports.verifyToken = function (req, res, next) {
  var token = req.headers.authorization?.split(" ")[1] || req.query.token; // Mengambil token dari header Authorization

  if (!token) {
    return res.status(401).json({ error: true, message: "Token not provided" });
  }

  jwt.verify(token, config.secret, function (err, decoded) {
    if (err) {
      return res.status(401).json({ error: true, message: "Invalid token" });
    }

    var query = "SELECT * FROM ?? WHERE ??=?";
    var table = ["auth_tokens", "token", token];

    query = mysql.format(query, table);
    connection.query(query, function (error, rows) {
      if (error) {
        console.log(error);
        return res.status(500).json({ error: true, message: "Database error" });
      }

      if (rows.length === 0) {
        return res.status(401).json({ error: true, message: "Invalid token" });
      }

      req.user = decoded;

      // Token valid, lanjutkan ke endpoint selanjutnya
      next();
    });
  });
};
