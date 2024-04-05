package com.learning.asteroid.Asteroidbackendkotlin.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.stereotype.Component

@Component
class JacksonMapper {
    val mapper: ObjectMapper = jacksonObjectMapper().registerKotlinModule()

}