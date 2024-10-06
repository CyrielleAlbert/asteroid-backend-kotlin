# ASTEROIDS Backend

This is the server to the ASTEROIDS Project. It's a  RESTful API built with Spring Boot and Java. 

## Introduction

The RESTful API has two GET endpoints: 

`/api/asteroids/fetchAllAsteroidsForPeriod`: An endpoint to fetch all asteroids that passed close to Earth within a given timeframe

`/api/asteroids/fetchAsteroidInformationById`: An endpoint to fetch an asteroids' information from it's ID. 

This API query the [NASA API](https://api.nasa.gov/).

## Project Status

What has been implemented so far:

- Two endpoints returning the response given by the NASA Api
- Caching of the response
- Connection to an elastic search cluster

There are several important missing features:

- Typing of the response of the NASA Api
- Filtering of data and data restructuring to send only the required information to the Frontend
- Handling of the different errors

## Getting Started


### Prerequisites

- Kotlin
- Gradle 7.5+

### Installation

### Create the override profile

First you need to create a new file that will store your [NASA API key](https://api.nasa.gov/). 
In `src/main/resources`, create a file called `application-override.properties`.
It should look like that: 
```
NASA_DEV_API_KEY=<yourKey>
```

### Build

`./gradlew build`

### Run 

I recommend using IntelliJ IDEA, for running the project. Otherwise, you can add your the NASA_DEV_API_KEY to the application.properties file that is located in src/main/resources and run the following command in your terminal: 

`./gradlew bootRun`

The server will be running on port `8081`.
