# Backend API Documentation 🧑‍💻

## API URL 🔗
[RejuviFy API](https://rejuvify-v1-cv7zfo7iga-et.a.run.app/)

## API Endpoint 🚪
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

## How to run this API on your local machine 💻
If you want to run this API Server on your local machine, you need to do this steps:
- First, clone this repository. `git clone https://github.com/lahiardhan/RejuviFy.git`
- Second, open terminal and go to this project's root directory.
- Third, type `npm install` in your terminal and hit enter button.
- Fourth, type `npm run start-dev` in your terminal and hit enter button.
- Finally, the server will run on your http://localhost:3000

## How to deploy this API to Cloud Run 🚀
If you want to deploy this API server to Cloud Run, you need to follow this steps:
- First, open your Google Cloud Console. https://console.cloud.google.com/
- Second, open the Cloud Shell at the right top corner in the Google Cloud Console. Make sure you enable Cloud Run API and Cloud Build API before.
- Third, copy the command below to cloning this repository into the Cloud Shell.
 ```
 git clone https://github.com/lahiardhan/RejuviFy.git
 ```
- Fourth, go to this project's root directory in the Cloud Shell.
- Fifth, copy the command below to build the image container and upload it to the Container Registry.
 ```
gcloud builds submit \
  --tag gcr.io/$GOOGLE_CLOUD_PROJECT/rejuvify-api-backend
  ```
- Sixth, copy the command below to deploy your image container to Cloud Run.
 ```
 gcloud run deploy rejuvify-api-backend \
  --image gcr.io/$GOOGLE_CLOUD_PROJECT/rejuvify-api-backend \
  --platform managed \
  --region asia-southeast2 \
  --allow-unauthenticated \
  --max-instances=3 \
  --port=3000
 ```
- Finally, your API server will be deploy to Cloud Run and you will get the URL in the Cloud Shell to access the your server.
