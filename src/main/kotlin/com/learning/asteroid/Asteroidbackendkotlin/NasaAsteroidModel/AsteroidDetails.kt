package com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel

data class AsteroidDetails(
    val name: String,
    val designation: String,
    val hazardous: Boolean,
    val absoluteMagnitudeH: Float,
    val estimatedDiameterMinInKm: Float,
    val estimatedDiameterMaxInKm: Float,
    val orbitalInformation: AsteroidOrbitalInformation,
    val closeApproach: List<AsteroidCloseApproach>
)