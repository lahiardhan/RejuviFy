const connection = require("../connect");
const mysql = require("mysql2");
const md5 = require('md5')
const jwt = require("jsonwebtoken");
const config = require("../config/secret");
const ip = require("ip");

//controller untuk register
exports.registrasi = function (req, res) {
  var post = {
    username: req.body.username,
    first_name: req.body.first_name,
    last_name: req.body.last_name,
    password: md5(req.body.password),
    phone: req.body.phone,
    gender: req.body.gender,
    age: req.body.age,
  };

  if (post.gender !== 'male' && post.gender !== 'female') {
    return res.status(400).json({ message: 'Gender harus dipilih antara male atau female.' });
  }

  var query = "SELECT * FROM ?? WHERE ??=? OR ??=?";
  var table = [
    "user",
    "phone",
    post.phone,
    "username",
    post.username,
  ];

  query = mysql.format(query, table);
  connection.query(query, function (error, rows){
    if (error) {
      console.log(error);
    } else {
      if (rows.length == 0) {
        var query = "INSERT INTO ?? SET ?";
        var table = ["user"];
        query = mysql.format(query, table);
        connection.query(query, post, function (error, rows) {
          if (error) {
            console.log(error);
          } else {
            return res.status(200).json({message: "Berhasil melakukan registrasi akun!"});
          }
        });
      } else {
        return res.status(400).json({message: "Nomor HP atau username sudah terdaftar!"});
      }
    }
  });
};


//controller untuk login
exports.login = function (req, res) {
  var post = {
    phone: req.body.phone,
    password: req.body.password,
  };

  var query = "SELECT * FROM ?? WHERE ??=? AND ??=?";
  var table = [
    "user",
    "phone",
    post.phone,
    "password",
    md5(post.password),
  ];

  query = mysql.format(query, table);
  connection.query(query, function (error, rows) {
    if (error) {
      console.log(error);
    } else {
      if (rows.length == 1) {
        //apakah ketika menampilkan data dari query itu ada datanya
        var token = jwt.sign({ rows }, config.secret, {
          expiresIn: 1440, //25menit
        });
        id_usertoken = rows[0].id_user;

        var data = {
          id_usertoken: id_usertoken,
          token: token,
          ip_address: ip.address(),
        };

        //Token JWT nya disimpan dalam local storage frontend
        var query = "INSERT INTO ?? SET ?";
        var table = ["auth_tokens"];

        query = mysql.format(query, table);
        connection.query(query, data, function (error, rows) {
          if (error) {
            console.log(error);
          } else {
            return res.status(200).json({
              success: true,
              message: "Token JWT tergenerate!",
              token: token,
              currUser: data.id_usertoken,
            });
          }
        });
      } else {
        return res.status(400).json({ error: true, Message: "Nomor HP atau password salah!" });
      }
    }
  });
};

//Mendapatkan data profil
exports.getProfile = function (req, res) {
  const token = req.headers.authorization?.split(" ")[1]; // Mengambil token dari header Authorization

  if (!token) {
    return res.status(401).json({ error: true, message: "Token not provided" });
  }

  jwt.verify(token, config.secret, function (err, decoded) {
    if (err) {
      return res.status(401).json({ error: true, message: "Invalid token" });
    }

    const userId = decoded.rows[0].id_user; // Mengambil ID user dari token

    // Buat query untuk mengambil profil user berdasarkan ID
    const query = "SELECT * FROM ?? WHERE ??=?";
    const table = ["user", "id_user", userId];

    const formattedQuery = mysql.format(query, table);
    connection.query(formattedQuery, function (error, rows) {
      if (error) {
        console.log(error);
        return res.status(500).json({ error: true, message: "Database error" });
      }

      if (rows.length === 0) {
        return res.status(404).json({ error: true, message: "User not found" });
      }

      const user = rows[0];

      return res.status(200).json({ success: true, user });
    });
  });
};

//controller untuk logout
exports.logout = function (req, res) {
  var token = req.headers.authorization?.split(" ")[1]; // Mengambil token dari header Authorization

  var query = "DELETE FROM ?? WHERE ?? = ?";
  var table = ["auth_tokens", "token", token];

  query = mysql.format(query, table);
  connection.query(query, function (error, result) {
    if (error) {
      console.log(error);
      return res.status(500).json({ error: true, message: "Internal Server Error" });
    } else {
      if (result.affectedRows === 0) {
        return res.status(401).json({ error: true, message: "Invalid token" });
      }
      return res.status(200).json({ success: true, message: "Logout successful" });
    }
  });
};
