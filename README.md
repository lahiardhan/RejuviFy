# RejuviFy - Cloud Computing Documentation

## Tech Used
Our project is created with:
* Express.js
* Cloud SQL
* Cloud Run
* Cloud Storage

## API URL
[RejuviFy API](https://rejuvify-v1-cv7zfo7iga-et.a.run.app/)

## API Endpoint
If you want to access our endpoints, first you need to access register and login endpoints to get the JWT Token for get the credentials to accessing our other endpoints. For details please check the tables below to see the API documentation and what endpoints need the JWT Token (showed in checklist):
|             Endpoint            | Method |                                         Input                                                    |                                          Description                                          |  JWT Token  |
| :-----------------------------: | :----: | :----------------------------------------------------------------------------------------------: | :-------------------------------------------------------------------------------------------: | :---------: |
|              /                  |   GET  |                                                 -                                                |                                        Accessing our root endpoints                           |   &#9744;   |
|          /register              |  POST  |                  username, first_name, last_name, password, phone, gender, age                   |                                       Register account for new user                           |   &#9744;   |
|           /login                |  POST  |                                         phone, password                                          |                                 Login to access the feature in application                    |   &#9744;   |
|          /profile               |   GET  |                                                 -                                                |                                       Show the detail data from user                          |   &#9745;   |
|       /profile/edit             |   PUT  |    Anything you want to edit from username, first_name, last_name, password, phone, gender, age  |                                           Edit profile from user                              |   &#9745;   |
|      /profile/delete            | DELETE |                                                 -                                                |                                          Delete profile from user                             |   &#9745;   |
|       /cari-klinik              |   GET  |                                       latitude, longitude                                        |                                  Show the beauty clinic near user location                    |   &#9745;   |
|    /cari-klinik/keyword         |   GET  |                                              keyword                                             |                                 Show the beauty clinic based on the input keyword             |   &#9745;   |
|            /news                |   GET  |                                                 -                                                |                                   Show the articles about facial treatment                    |   &#9745;   |
|          /logout                |  POST  |                                                 -                                                |                                           Logout from the account                             |   &#9745;   |

## How to run this API on your local machine
If you want to run this API Server on your local machine, you need to do this steps:
- First, clone this repository. `git clone https://github.com/lahiardhan/RejuviFy.git`
- Second, open terminal and go to this project's root directory.
- Third, type `npm install` in your terminal and hit enter button.
- Fourth, type `npm run start-dev` in your terminal.
- Finally, the server will run on your http://localhost:3000
