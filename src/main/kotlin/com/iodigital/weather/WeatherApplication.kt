package com.iodigital.weather

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.http.client.reactive.ReactorResourceFactory
import org.springframework.web.reactive.function.client.WebClient
import java.time.Duration

@EnableR2dbcRepositories
@SpringBootApplication
class WeatherApplication {
    @Bean
    fun resourceFactory() = ReactorResourceFactory()

    @Bean
    fun webClient() =
        WebClient
            .builder()
            .clientConnector(
                ReactorClientHttpConnector(resourceFactory()) {
                    it.responseTimeout(Duration.ofSeconds(10))
                }
            )
            .build()
}

fun main(args: Array<String>) {
    SpringApplication.run(WeatherApplication::class.java, *args)
}
