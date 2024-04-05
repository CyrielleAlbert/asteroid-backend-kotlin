package com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.service

import co.elastic.clients.elasticsearch.core.GetSourceRequest
import co.elastic.clients.elasticsearch.core.IndexRequest
import com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.ElasticSearchRepository
import com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.model.AsteroidCloseApproach
import com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.model.AsteroidDetails
import com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.AsteroidTest
import com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.DTO.AsteroidDetailsDTO
import com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidService.AsteroidService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class ElasticSearchService(val elasticSearch: ElasticSearchRepository, val asteroidService: AsteroidService) {

    fun getAsteroidById(asteroidId: String): AsteroidDetailsDTO? {
        return asteroidService.getAsteroidDetailsData(asteroidId)
    }

    fun getAsteroidByIdFromES(asteroidId: String): AsteroidDetails? {
        val getSourceRequest = GetSourceRequest.Builder().index("asteroids_test").id(asteroidId).build()
        val res = elasticSearch.getSingleAsteroid(getSourceRequest)
        println(res)
        return res
    }

    fun indexAsteroidTest(asteroid: AsteroidTest) {
        val indexRequest = IndexRequest.of { i: IndexRequest.Builder<AsteroidTest> ->
            i.index("asteroids_test").id(asteroid.id).document(asteroid)
        }
        // elasticSearch.index(indexRequest)

        logger.info("Indexation of test asteroid: $asteroid")
    }

    fun indexAsteroidById(asteroidId: String): AsteroidDetailsDTO? {
        val asteroidData = getAsteroidById(asteroidId)
        logger.info("asteroidData: asteroidData")
        return if (asteroidData == null) {
            null
        } else {
            val asteroidDetails = AsteroidDetails(
                links = asteroidData.links.toLinks(),
                id = asteroidData.id,
                neoReferenceId = asteroidData.neoReferenceId,
                name = asteroidData.name,
                absoluteMagnitude = asteroidData.absoluteMagnitude,
                estimatedDiameter = asteroidData.estimatedDiameter.toEstimatedDiameter(),
                potentiallyHazardous = asteroidData.isPotentiallyHazardous,
                sentryObject = asteroidData.isSentryObject,
                nasaJplUrl = asteroidData.nasaJplUrl
            )

            val asteroidIndexRequest = IndexRequest.of { i: IndexRequest.Builder<AsteroidDetails> ->
                i.index("asteroids_test").id(asteroidData.id).document(asteroidDetails)
            }
            elasticSearch.indexSingleAsteroid(asteroidIndexRequest)
            asteroidData.closeApproachData.forEach {
                val uuid = UUID.randomUUID().toString()
                val closeApproach = AsteroidCloseApproach(
                    asteroidId,
                    it.closeApproachDate,
                    it.closeApproachDateFull,
                    it.epochDateCloseApproach,
                    it.relativeVelocity,
                    it.missDistance,
                    it.orbitingBody,
                    uuid
                )
                val closeApproachIndexRequest = IndexRequest.of { i: IndexRequest.Builder<AsteroidCloseApproach> ->
                    i.index("close_approach_test").id(uuid).document(closeApproach)
                }
                elasticSearch.indexCloseApproachData(closeApproachIndexRequest)
            }
            asteroidData
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ElasticSearchService::class.java)
    }
}