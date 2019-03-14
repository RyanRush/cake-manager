## Project title
A simple API which provides the following capabilities:
1. Fetch a collection of cake resources.
2. Create a new cake resource.
3. Download all cake resources in a JSON formatted file.

## Deployment Information

The application is currently running here: https://cake-manager-demo.herokuapp.com/ 

## Build status

[![Build Status](https://travis-ci.org/RyanRush/cake-manager.svg?branch=master)](https://travis-ci.org/RyanRush/cake-manager)

## Tests
1. Unit tests: **./gradlew test**
2. Integration tests: **./gradlew integrationTest**

## Build & Run Locally
#### Gradle
1. From the cake-manager root directory:
    - **./gradlew clean build bootRun**
    
2. The api will be accessible from: **http://localhost:8080/**

#### Docker
1. From the cake-manager root directory:
    - **./gradlew clean build**
    - **docker build -t cake-manager-demo .**
    - **docker run -p 8080:8080 cake-manager-demo**

2. The api will be accessible from: **http://localhost:8080/**

## How to use?
#### REST API

1. Fetch all cake resources:
    - curl https://cake-manager-demo.herokuapp.com/api/
2. Create new cake resource:
    - curl -X POST -H "Content-Type: application/json" -d '{"title":"Cheesecake","description":"description 21","image":"image 21"}' https://cake-manager-demo.herokuapp.com/api/cakes
3. Download cake resources as json file
    - curl https://cake-manager-demo.herokuapp.com/api/cakes --output cakes.json

#### UI

1. View cake resources:
    - https://cake-manager-demo.herokuapp.com/
2. Create new cake resource:
    - https://cake-manager-demo.herokuapp.com/ 
    - Click on 'Add Cake' link

## Useful links

1. DockerHub : https://hub.docker.com/r/ryanrush/cake-manager-api-docker-repo
2. TravisCI : https://travis-ci.org/RyanRush/cake-manager