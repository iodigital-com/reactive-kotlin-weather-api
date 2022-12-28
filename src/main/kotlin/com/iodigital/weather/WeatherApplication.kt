package com.iodigital.weather

import org.springframework.boot.runApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.http.client.reactive.ReactorResourceFactory
import org.springframework.web.reactive.function.client.WebClient
import reactor.blockhound.BlockHound
import reactor.blockhound.integration.BlockHoundIntegration
import java.time.Duration

@SpringBootApplication
class WeatherApplication {
    init {
        BlockHound.install(
            BlockHoundIntegration {
                it
                    .allowBlockingCallsInside(
                        "java.util.ServiceLoader\$LazyClassPathLookupIterator",
                        "parse"
                    )
                    .allowBlockingCallsInside(
                        "kotlin.reflect.jvm.ReflectJvmMapping",
                        "getKotlinFunction"
                    ).allowBlockingCallsInside(
                        "kotlin.reflect.full.KClasses",
                        "getMemberProperties"
                    )
            }
        )
    }

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
    runApplication<WeatherApplication>(*args)
}
