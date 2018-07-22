#!/usr/bin/env bash
./gradlew build
docker build -t gcr.io/arafat-project/arafat-project . --no-cache
# docker login -u _json_key -p "$(cat /home/komen/.ssh/arafat-project-4094e61ad8c8.json)" https://gcr.io #only run once (the path is path to the credentials file -got from google IMA and Admin)
docker push gcr.io/arafat-project/arafat-project
ssh 35.229.104.163 sudo docker pull gcr.io/arafat-project/arafat-project
ssh 35.229.104.163 sudo docker stop arafat-project
ssh 35.229.104.163 sudo docker rm arafat-project
ssh 35.229.104.163 sudo docker run -d -p 9001:5000 --name arafat-project --restart always gcr.io/arafat-project/arafat-project