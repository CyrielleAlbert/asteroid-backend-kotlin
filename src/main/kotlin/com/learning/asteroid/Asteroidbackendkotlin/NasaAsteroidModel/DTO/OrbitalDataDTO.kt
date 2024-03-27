package com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.DTO

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrbitalDataDTO(
    @SerialName("orbit_id") val orbitId: String,
    @SerialName("orbit_determination_date") val orbitDeterminationDate: String,
    @SerialName("first_observation_date") val firstObservationDate: String,
    @SerialName("last_observation_date") val lastObservationDate: String,
    @SerialName("data_arc_in_days") val dataArcInDays: Int,
    @SerialName("observations_used") val observationsUsed: Int,
    @SerialName("orbit_uncertainty") val orbitUncertainty: String,
    @SerialName("minimum_orbit_intersection") val minOrbitIntersection: String,
    @SerialName("jupiter_tisserand_invariant") val jupiterTisserandInvariant: String,
    @SerialName("epoch_osculation") val epochOsculation: String,
    @SerialName("eccentricity") val eccentricity: String,
    @SerialName("semi_major_axis") val semiMajorAxis: String,
    @SerialName("inclination") val inclination: String,
    @SerialName("ascending_node_longitude") val ascendingNodeLongitude: String,
    @SerialName("orbital_period") val orbitalPeriod: String,
    @SerialName("perihelion_distance") val perihelionDistance: String,
    @SerialName("perihelion_argument") val perihelionArgument: String,
    @SerialName("aphelion_distance") val aphelionDistance: String,
    @SerialName("perihelion_time") val perihelionTime: String,
    @SerialName("mean_anomaly") val meanAnomaly: String,
    @SerialName("mean_motion") val meanMotion: String,
    @SerialName("equinox") val equinox: String,
    @SerialName("orbit_class") val orbitClass: OrbitClassDTO
)

@Serializable
data class OrbitClassDTO(
    @SerialName("orbit_class_type") val orbitClassType: String,
    @SerialName("orbit_class_description") val orbitClassDescription: String,
    @SerialName("orbit_class_range") val orbitClassRange: String,
)
