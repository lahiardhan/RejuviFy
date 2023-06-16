const jwt = require("jsonwebtoken");
const config = require("../config/secret");
const connection = require("../connect");
const mysql = require("mysql2");

//controller untuk Edit Profil
exports.editProfil = function (req, res) {
  var token = req.headers.authorization?.split(" ")[1]; // Mengambil token dari header Authorization

  if (!token) {
    return res.status(401).json({ error: true, message: "Token not provided" });
  }

  jwt.verify(token, config.secret, function (err, decoded) {
    if (err) {
      return res.status(401).json({ error: true, message: "Invalid token" });
    }

    var userId = decoded.rows[0].id_user; // Mengambil ID user dari token

    // Buat query untuk mengambil profil user berdasarkan ID
    var query = "SELECT * FROM ?? WHERE ??=?";
    var table = ["user", "id_user", userId];

    query = mysql.format(query, table);
    connection.query(query, function (error, rows) {
      if (error) {
        console.log(error);
        return res.status(500).json({ error: true, message: "Database error" });
      }

      if (rows.length === 0) {
        return res.status(404).json({ error: true, message: "User not found" });
      }

      var user = rows[0];

      // Update data profil hanya untuk bagian yang diubah
      if (req.body.first_name) {
        user.first_name = req.body.first_name;
      }

      if (req.body.last_name) {
        user.last_name = req.body.last_name;
      }

      if (req.body.phone) {
        user.phone = req.body.phone;
      }

      if (req.body.gender) {
        user.gender = req.body.gender;
      }

      if (user.gender !== "male" && user.gender !== "female") {
        return res
          .status(400)
          .json({ message: "Gender harus dipilih antara male atau female." });
      }

      if (req.body.age) {
        user.age = req.body.age;
      }

      // Buat query untuk mengupdate profil user berdasarkan ID
      var updateQuery = "UPDATE ?? SET ? WHERE ??=?";
      var updateTable = ["user", user, "id_user", userId];

      updateQuery = mysql.format(updateQuery, updateTable);
      connection.query(updateQuery, function (error, result) {
        if (error) {
          console.log(error);
          return res
            .status(500)
            .json({ error: true, message: "Database error" });
        }

        // Update objek req.user dengan data profil yang diperbarui
        req.user = user;

        return res
          .status(200)
          .json({ success: true, message: "Profil berhasil diperbarui" });
      });
    });
  });
};

  
  