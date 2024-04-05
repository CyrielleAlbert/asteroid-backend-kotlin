package com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.model

import com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.DTO.MissDistanceDTO
import com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.DTO.RelativeVelocityDTO

class AsteroidCloseApproach(
    val asteroidId: String,
    val closeApproachDate: String,
    val closeApproachDateFull: String,
    val epochDateCloseApproach: Long,
    val relativeVelocity: RelativeVelocityDTO,
    val missDistance: MissDistanceDTO,
    val orbitingBody: String,
    val id: String,
)
