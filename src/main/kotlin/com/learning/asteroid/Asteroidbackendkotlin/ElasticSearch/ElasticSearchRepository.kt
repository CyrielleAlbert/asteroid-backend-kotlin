package com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch

import co.elastic.clients.elasticsearch.core.*
import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.model.AsteroidCloseApproach
import com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch.model.AsteroidDetails
import com.learning.asteroid.Asteroidbackendkotlin.utils.JacksonMapper
import org.springframework.stereotype.Repository



@Repository
class ElasticSearchRepository(private val elasticSearchConfiguration: ElasticSearchConfiguration, private val jacksonMapper: JacksonMapper) {

    val esClient = elasticSearchConfiguration.esClient()
    fun search(searchRequest: SearchRequest) {
        //TODO
    }

    fun getSingleAsteroid(getSourceRequest: GetSourceRequest): AsteroidDetails? {
        val res =  esClient.getSource(getSourceRequest, JsonNode::class.java)
        println(res.toString())
        val res2 = jacksonMapper.mapper.readValue(res.valueBody().toString(), AsteroidDetails::class.java)
        return res2;
    }

    fun indexSingleAsteroid(indexRequest: IndexRequest<AsteroidDetails?>) {
        esClient.index(indexRequest)
    }

    fun indexCloseApproachData(indexRequest: IndexRequest<AsteroidCloseApproach?>) {
        esClient.index(indexRequest)
    }

}