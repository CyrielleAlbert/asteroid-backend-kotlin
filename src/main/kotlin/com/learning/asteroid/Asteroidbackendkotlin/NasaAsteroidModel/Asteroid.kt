package com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel
import kotlinx.serialization.Serializable


@Serializable
data class Asteroid(
    val name: String,
    val id: String,
    val missDistance: Float?,
    val hazardous: Boolean?,
)