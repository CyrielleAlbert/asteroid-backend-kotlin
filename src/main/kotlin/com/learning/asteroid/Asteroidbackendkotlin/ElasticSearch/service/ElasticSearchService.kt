package com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.service

import co.elastic.clients.elasticsearch.core.IndexRequest
import com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.ElasticSearchRepository
import com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.AsteroidTest
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ElasticSearchService(val elasticSearch: ElasticSearchRepository) {

    fun getAsteroidById(asteroidId: String) {
        //TODO: Get an asteroidById
    }

    fun indexAsteroidById(asteroid: AsteroidTest) {
        val indexRequest = IndexRequest.of { i: IndexRequest.Builder<AsteroidTest> ->
            i.index("asteroids_test").id(asteroid.id).document(asteroid)
        }
        elasticSearch.index(indexRequest)

        logger.info("Indexation of test asteroid: $asteroid")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ElasticSearchService::class.java)
    }
}