#!/usr/bin/env bash
./gradlew clean build
docker build -t gcr.io/arafat-project/arafat-project .
#docker login -u _json_key -p "$(cat /home/komen/Downloads/arafat-project-d69048874c78.json)" https://gcr.io #only run once (the path is path to the credentials file -got from google IMA and Admin)
docker push gcr.io/arafat-project/arafat-project
ssh 35.229.104.163 sudo docker pull gcr.io/arafat-project/arafat-project
ssh 35.229.104.163 sudo docker stop arafat-project
ssh 35.229.104.163 sudo docker rm arafat-project
ssh 35.229.104.163 sudo docker run -d -p 9001:5000 --name arafat-project --restart always gcr.io/arafat-project/arafat-project