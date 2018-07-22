#!/usr/bin/env bash
./gradlew build
docker build -t gcr.io/arafat-project/arafat-project . --no-cache
docker stop arafat-project
docker rm arafat-project
docker run -d -p 9001:5000 --name arafat-project --restart always gcr.io/arafat-project/arafat-project