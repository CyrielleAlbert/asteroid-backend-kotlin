package com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel

data class AsteroidOrbitalInformation(
    val orbitId: String,
    val inclination: Float,
    val meanMotion: Float,
    val firstObservableDate: String,
    val lastObservationDate: String,
)