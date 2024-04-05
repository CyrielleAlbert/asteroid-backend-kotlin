package com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.DTO

import com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.model.Links
import kotlinx.serialization.Serializable

@Serializable
data class LinksDTO(
    val next: String? = null,
    val prev: String? = null,
    val self: String,
) {
    fun toLinks(): Links {
        return Links(self)
    }
}
