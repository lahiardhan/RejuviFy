# Machine Learning API Documentation 🤖

## API URL 🔗
[RejuviFy Machine Learning API](https://rejuvify-ml-prod-cv7zfo7iga-et.a.run.app/)

## API Endpoint 🚪
If you want to access our endpoints, first you need to access register and login endpoints to get the JWT Token for get the credentials to accessing our Machine Learning API endpoints. You can access register and login endpoints from [RejuviFy Register API](https://rejuvify-v1-cv7zfo7iga-et.a.run.app/register) and [RejuviFy Login API](https://rejuvify-v1-cv7zfo7iga-et.a.run.app/login). For details please check the tables below to see the API documentation and what endpoints need the JWT Token (showed in checklist):
|             Endpoint            | Method |                                         Input                                                    |                                          Description                                                                                                                                                                   |  JWT Token  |
| :-----------------------------: | :----: | :----------------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :---------: |
|              /                  |  GET   |                                                 -                                                |                                        Accessing our root endpoints                                                                                                                                                    |   &#9744;   |
|          /predict               |  POST  |                                   file1, file2, file3, file4                                     |Predict the user's face image using our Machine Learning models and the result will be the user's facial skin problems and their skin health. Don't forget to add four images in each key (file1, file2, file3, file4). |   &#9745;   |
|          /history               |  GET   |                                                 -                                                |                                 Show the history about the analyzed result from the user from day-by-day                                                                                                               |   &#9745;   |

## How to run this API on your local machine 💻
If you want to run this API Server on your local machine, you need to do this steps:
- First, clone this repository. `git clone https://github.com/lahiardhan/RejuviFy.git`
- Second, open terminal and go to this project's root directory.
- Third, type `pip install --no-cache-dir -r requirements.txt` in your terminal to install dependencies and hit enter button.
- Fourth, type `python deploy.py` in your terminal and hit enter button.
- Finally, the server will run on your http://localhost:9000

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
  --tag gcr.io/$GOOGLE_CLOUD_PROJECT/rejuvify-ml-api
  ```
- Sixth, copy the command below to deploy your image container to Cloud Run.
 ```
 gcloud run deploy rejuvify-ml-api \
  --image gcr.io/$GOOGLE_CLOUD_PROJECT/rejuvify-ml-api \
  --platform managed \
  --region asia-southeast2 \
  --allow-unauthenticated \
  --max-instances=3 \
  --port=9000 \
  --memory=8Gi
 ```
- Finally, your API server will be deploy to Cloud Run and you will get the URL in the Cloud Shell to access the your server.
