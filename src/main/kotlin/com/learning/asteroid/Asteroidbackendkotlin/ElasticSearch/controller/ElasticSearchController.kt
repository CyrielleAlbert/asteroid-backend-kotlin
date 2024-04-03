package com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.controller

import com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.service.ElasticSearchService
import com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.AsteroidTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/es")
@CrossOrigin(origins = ["http://localhost:3001"])
class ElasticSearchController(private val elasticSearchService: ElasticSearchService) {

    @GetMapping("/indexAsteroidTest")
    fun indexAsteroidTest(): ResponseEntity<String>{
        val asteroid = AsteroidTest("helloworld", 123, "0001")
        return try {
            elasticSearchService.indexAsteroidById(asteroid)
            ResponseEntity("Success", HttpStatus.OK)
        } catch (e: Exception){
            ResponseEntity("An error occured.", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}