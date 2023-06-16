const express = require('express');
const bodyParser = require('body-parser');
const app = express();

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

app.use((req, res, next) => {
    res.header('Access-Control-Allow-Origin', '*');
    next();
  });

const router = require('./routes/routes');
app.use('/', router);

app.listen(3000, ()=>{
    console.log('Server berjalan');
});