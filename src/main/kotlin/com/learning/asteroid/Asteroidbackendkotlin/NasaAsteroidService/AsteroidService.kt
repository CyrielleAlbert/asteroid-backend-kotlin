package com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidService

import com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.DTO.AsteroidDetailsDTO
import kotlinx.serialization.json.Json
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class AsteroidService {
    // Implement methods to fetch data from the NASA API

    @Value("\${NASA_API_ASTEROID_LIST_URL}")
    private val nasaAsteroidListApiUrl: String? = null

    @Value("\${NASA_API_ASTEROID_DETAILS_URL}")
    private val nasaAsteroidDetailsApiUrl: String? = null

    @Value("\${NASA_DEV_API_KEY}")
    private val nasaApiKey: String? = null

    fun getAsteroidsListData(startDate: String?, endDate: String?): String? {
        val apiUrl = String.format(
            "%s?start_date=%s&end_date=%s&api_key=%s",
            nasaAsteroidListApiUrl,
            startDate,
            endDate,
            nasaApiKey
        )
        val restTemplate = RestTemplate()
        return restTemplate.getForObject(apiUrl, String::class.java)
    }

    fun getAsteroidDetailsData(asteroidID: String?): AsteroidDetailsDTO? {
        val apiUrl =
            String.format("%s/%s?api_key=%s", nasaAsteroidDetailsApiUrl, asteroidID, nasaApiKey)
        val restTemplate = RestTemplate()
        val kotlinxJson = Json { ignoreUnknownKeys = true }
        return try {
            restTemplate.getForObject(apiUrl, String::class.java)
                ?.let { it -> kotlinxJson.decodeFromString<AsteroidDetailsDTO>(it) }

        } catch (e: Exception) {
            throw java.lang.Exception("error: ${e.message}")
        }
    }
}