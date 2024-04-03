package com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch

import co.elastic.clients.elasticsearch.ElasticsearchClient
import co.elastic.clients.elasticsearch.core.IndexRequest
import co.elastic.clients.elasticsearch.core.IndexResponse
import co.elastic.clients.elasticsearch.core.SearchRequest
import com.learning.asteroid.Asteroidbackendkotlin.NasaAsteroidModel.AsteroidTest
import org.springframework.stereotype.Repository

@Repository
class ElasticSearchRepository(private val elasticSearchConfiguration: ElasticSearchConfiguration) {

    val esClient = elasticSearchConfiguration.esClient()
    fun search(searchRequest: SearchRequest) {
        //TODO
    }

    fun index(indexRequest : IndexRequest<AsteroidTest>) {
        //TODO
        esClient.index(indexRequest)

    }

}