package com.learning.asteroid.Asteroidbackendkotlin.ElasticSearch

import co.elastic.clients.elasticsearch.ElasticsearchClient
import co.elastic.clients.json.jackson.JacksonJsonpMapper
import co.elastic.clients.transport.rest_client.RestClientTransport
import org.apache.http.HttpHost
import org.apache.http.message.BasicHeader
import org.elasticsearch.client.RestClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ElasticSearchConfiguration {

    @Value("\${ELASTIC_SEARCH_HOST_URL}")
    private val elasticSearchHostUrl: String? = null

    @Value("\${ELASTIC_SEARCH_API_KEY}")
    private val elasticSearchApiKey: String? = null

    fun esClient(): ElasticsearchClient {
        val restClient: RestClient = RestClient
            .builder(HttpHost.create((elasticSearchHostUrl)))
            .setDefaultHeaders(arrayOf(BasicHeader("Authorization", "ApiKey $elasticSearchApiKey")))
            .build()

        val transport = RestClientTransport(restClient, JacksonJsonpMapper())
        return ElasticsearchClient(transport)
    }

}
//org.jetbrains.kotlin.analyzer.CompilationErrorException : Could not load module <built-ins module> in an attempt to find deserializer for symbol kotlin/intArrayOf|intArrayOf(kotlin.IntArray...){}kotlin.IntArray[0].