package com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.model

data class AsteroidDetails(
    val links: Links?,
    val id: String?,
    val neoReferenceId: String?,
    val name: String?,
    val nasaJplUrl: String?,
    val absoluteMagnitude: Double?,
    val estimatedDiameter: EstimatedDiameter?,
    val sentryObject: Boolean?,
    val potentiallyHazardous: Boolean?
)

data class Links(
    val self: String?
)

data class EstimatedDiameter(
    val kilometers: Diameter?,
    val meters: Diameter?,
    val miles: Diameter?,
    val feet: Diameter?
)

data class Diameter(
    val estimatedDiameterMin: Double?,
    val estimatedDiameterMax: Double?,
)