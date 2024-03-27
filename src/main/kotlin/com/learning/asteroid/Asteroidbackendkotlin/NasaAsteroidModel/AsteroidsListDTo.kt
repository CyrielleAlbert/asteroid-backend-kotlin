package com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.math.BigInteger

@Serializable
data class AsteroidsListDTO(
    val links: Links,
    @SerialName("element_count") val elementCount: Int,
    @SerialName("near_earth_objects") val nearEarthObjects: Map<String, List<AsteroidDTO>>

)

@Serializable
data class Links(
    val next: String? = null,
    val prev: String? = null,
    val self: String? = null,
)

@Serializable
data class AsteroidDTO(
    val links: Links,
    val id: String,
    @SerialName("neo_reference_id") val neoReferenceId: String,
    val name: String,
    @SerialName("name_jpl_url") val nameJplUrl: String?=null,
    @SerialName("absolute_magnitude_h") val absoluteMagnitudeH: Float,
    @SerialName("estimated_diameter") val estimatedDiameter: DiameterDTO,
    @SerialName("is_potentially_hazardous_asteroid") val isPotentiallyHazardous: Boolean,
    @SerialName("close_approach_data") val closeApproachData: List<CloseApproachDTO>,
    @SerialName("is_sentry_object") val isSentryObject: Boolean
)

@Serializable
data class DiameterDTO(
    val kilometers: DiametersMinMax,
    val meters: DiametersMinMax,
    val miles: DiametersMinMax,
    val feet: DiametersMinMax,
)

@Serializable
data class DiametersMinMax(
    @SerialName("estimated_diameter_min") val estimatedDiameterMin: Float,
    @SerialName("estimated_diameter_max") val estimatedDiameterMax: Float,
)

@Serializable
data class CloseApproachDTO(
    @SerialName("close_approach_date") val closeApproachDate: String,
    @SerialName("close_approach_date_full") val closeApproachDateFull: String,
    @SerialName("epoch_date_close_approach") val epochDateCloseApproach: Long,
    @SerialName("relative_velocity") val relativeVelocity: RelativeVelocityDTO,
    @SerialName("miss_distance") val missDistance: MissDistanceDTO,
    @SerialName("orbiting_body") val orbitingBody: String,
)

@Serializable
data class RelativeVelocityDTO(
    @SerialName("kilometers_per_second") val kilometersPerSecond: String,
    @SerialName("kilometers_per_hour") val kilometersPerHour: String,
    @SerialName("miles_per_hour") val milesPerHour: String,
)

@Serializable
data class MissDistanceDTO(
    val astronomical: String,
    val lunar: String,
    val kilometers: String,
    val miles: String,
)