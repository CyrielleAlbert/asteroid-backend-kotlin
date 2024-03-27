package com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.DTO

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AsteroidsListDTO(
    val links: Links,
    @SerialName("element_count") val elementCount: Int,
    @SerialName("near_earth_objects") val nearEarthObjects: Map<String, List<AsteroidDetailsDTO>>

)
