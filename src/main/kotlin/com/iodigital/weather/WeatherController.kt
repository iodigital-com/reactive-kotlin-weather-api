package com.iodigital.weather

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/weather")
class WeatherController(private val service: WeatherService) {
    @GetMapping
    fun getAll(): Flux<WeatherInfo> =
        service.getAll()

    @GetMapping("/city/{city}")
    fun getForCity(@PathVariable city: String): Flux<WeatherInfo> =
        service.getForCity(city)
}
