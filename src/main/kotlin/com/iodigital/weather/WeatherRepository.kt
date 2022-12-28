package com.iodigital.weather

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface WeatherRepository : ReactiveCrudRepository<WeatherInfo, Long> {
    fun findAllByCityIgnoreCase(city: String): Flux<WeatherInfo>
}
