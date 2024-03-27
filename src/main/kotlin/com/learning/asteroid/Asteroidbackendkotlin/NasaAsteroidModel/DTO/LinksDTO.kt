package com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.DTO

import kotlinx.serialization.Serializable

@Serializable
data class Links(
    val next: String? = null,
    val prev: String? = null,
    val self: String? = null,
)
