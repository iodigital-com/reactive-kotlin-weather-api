package com.iodigital.weather.api

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class WeatherAPIClient(
    private val http: WebClient,
    @Value("\${weatherapi.host}") private val host: String,
    @Value("\${weatherapi.api-key}") private val apiKey: String
) {
    fun getWeather(city: String): Mono<WeatherAPIResponse> =
        http
            .get()
            .uri("$host/v1/forecast.json?key=$apiKey&q=$city&days=7")
            .exchangeToMono { it.bodyToMono(WeatherAPIResponse::class.java) }
            .doFirst { log.info("Getting weather forecast for city $city") }
            .doOnError { log.error("Cannot get weather forecast for $city", it) }
            .doOnSuccess { log.info("Weather forecast for city $city: $it") }

    companion object {
        private val log = LoggerFactory.getLogger(WeatherAPIClient::class.java)
    }
}
