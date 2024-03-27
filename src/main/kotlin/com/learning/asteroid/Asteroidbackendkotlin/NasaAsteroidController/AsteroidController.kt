package com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidController

import com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.Asteroid
import com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.DTO.AsteroidDetailsDTO
import com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.DTO.AsteroidsListDTO
import com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidService.AsteroidService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*

@RestController
@RequestMapping("/api/asteroids")
@CrossOrigin(origins = ["http://localhost:3001"])
class AsteroidController(private val asteroidService: AsteroidService) {

    @GetMapping("/fetchAllAsteroidsForPeriod")
    fun fetchAllAsteroidsForPeriod(
        @RequestParam startDate: String,
        @RequestParam endDate: String
    ): ResponseEntity<AsteroidsListDTO?>? {
        return try {
            val asteroids: String = asteroidService.getAsteroidsListData(startDate, endDate) ?: return ResponseEntity(
                null,
                HttpStatus.NOT_FOUND
            )
            val kotlinxJson = Json {ignoreUnknownKeys = true}
            val asteroidList = kotlinxJson.decodeFromString<AsteroidsListDTO>(asteroids)
            ResponseEntity(asteroidList, HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/fetchAsteroidInformationById")
    fun fetchAsteroidInformationById(@RequestParam asteroidId: String): ResponseEntity<AsteroidDetailsDTO?> {
        return try {
            val asteroidInformation: String =
                asteroidService.getAsteroidDetailsData(asteroidId) ?: return ResponseEntity(
                    null,
                    HttpStatus.NOT_FOUND
                )
            val kotlinxJson = Json { ignoreUnknownKeys = true }
            val asteroid = kotlinxJson.decodeFromString<AsteroidDetailsDTO>(asteroidInformation)
            ResponseEntity(asteroid, HttpStatus.OK)

        } catch (e: Exception) {
            ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }


}