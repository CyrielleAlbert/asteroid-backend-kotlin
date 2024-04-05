package com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.controller

import com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.model.AsteroidDetails
import com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.service.ElasticSearchService
import com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.AsteroidTest
import com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.DTO.AsteroidDetailsDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/es")
@CrossOrigin(origins = ["http://localhost:3001"])
class ElasticSearchController(private val elasticSearchService: ElasticSearchService) {

    @GetMapping("/indexAsteroidTest")
    fun indexAsteroidTest(): ResponseEntity<String> {
        val asteroid = AsteroidTest("helloworld", 123, "0001")
        return try {
            elasticSearchService.indexAsteroidTest(asteroid)
            ResponseEntity("Success", HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity("An error occured.", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/indexAsteroidById")
    fun indexAsteroidById(@RequestParam asteroidId: String): ResponseEntity<AsteroidDetailsDTO> {
        return try {
            val asteroid = elasticSearchService.indexAsteroidById(asteroidId)
            if (asteroid == null) {
                ResponseEntity(null, HttpStatus.NOT_FOUND)
            }
            ResponseEntity(asteroid, HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @GetMapping("/getAsteroidById")
    fun getAsteroidById(@RequestParam asteroidId: String): ResponseEntity<AsteroidDetails> {
        return try {
            val asteroid = elasticSearchService.getAsteroidByIdFromES(asteroidId)
            if (asteroid == null){
                ResponseEntity(null, HttpStatus.NOT_FOUND)
            }
            ResponseEntity(asteroid, HttpStatus.OK)

        }catch (e: Exception){
            println(e)
            ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}