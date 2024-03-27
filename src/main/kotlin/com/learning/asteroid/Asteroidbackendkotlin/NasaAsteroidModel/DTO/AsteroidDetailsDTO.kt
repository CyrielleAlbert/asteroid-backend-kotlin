package com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.DTO

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AsteroidDetailsDTO(
    val links: Links, //TODO: add to common DTO
    val id: String,
    @SerialName("neo_reference_id") val neoReferenceId: String,
    val name: String,
    val designation: String? = null,
    @SerialName("nasa_jpl_url") val nasaJplUrl: String,
    @SerialName("absolute_magnitude_h") val absoluteMagnitude: String,
    @SerialName("estimated_diameter") val estimatedDiameter: DiameterDTO,
    @SerialName("is_potentially_hazardous_asteroid") val isPotentiallyHazardous: Boolean,
    @SerialName("close_approach_data") val closeApproachData: List<CloseApproachDTO>,
    @SerialName("orbital_data") val orbitalData: OrbitalDataDTO? = null,
    @SerialName("is_sentry_object") val isSentryObject: Boolean,
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