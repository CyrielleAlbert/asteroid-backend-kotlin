package com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.model

data class OrbitalData(
    var orbitId: String,
    var orbitDeterminationDate: String,
    var firstObservationDate: String,
    var lastObservationDate: String,
    var dataArcInDays: Int,
    var observationsUsed: Int,
    var orbitUncertainty: String,
    var minOrbitIntersection: String,
    var jupiterTisserandInvariant: String,
    var epochOsculation: String,
    var eccentricity: String,
    var semiMajorAxis: String,
    var inclination: String,
    var ascendingNodeLongitude: String,
    var orbitalPeriod: String,
    var perihelionDistance: String,
    var perihelionArgument: String,
    var aphelionDistance: String,
    var perihelionTime: String,
    var meanAnomaly: String,
    var meanMotion: String,
    var equinox: String,
    var orbitClass: OrbitClass
)

data class OrbitClass(
    var orbitClassType: String,
    var orbitClassDescription: String,
    var orbitClassRange: String,
)
