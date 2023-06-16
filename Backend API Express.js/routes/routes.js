const express = require("express");
const router = express.Router();
const auth = require('../middleware/auth');
const { verifyToken } = require('../middleware/verifikasi');
const klinikController = require('../controllers/klinikController');
const editProfileController = require('../controllers/editProfileContoller');
const deleteProfileController = require('../controllers/deleteProfileController');
const newsController = require('../controllers/newsController');

//Endpoint awal
router.get("/", (req, res) => {
    res.status(200).json({
        "message": "Welcome to Rejuvify API server. We recommend that you first register and login before accessing our endpoints."
    })
});

//Endpoint untuk mendapatkan token JWT. Jika belum punya akun maka harus registrasi
router.post("/register", auth.registrasi);
router.post("/login", auth.login);

//Endpoint yang membutuhkan verifikasi token JWT. Token JWT didapat setelah login
router.get("/profile", verifyToken, auth.getProfile);
router.put("/profile/edit", verifyToken, editProfileController.editProfil);
router.delete("/profile/delete", verifyToken, deleteProfileController.deleteAccount);
router.get("/news", verifyToken, newsController.getNews);
router.get('/cari-klinik', verifyToken, klinikController.cariKlinik);
router.get('/cari-klinik/keyword', verifyToken, klinikController.cariKlinikDenganKeyword);
router.post("/logout", auth.logout);

module.exports = router;