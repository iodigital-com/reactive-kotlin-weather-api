package com.iodigital.weather

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/weather")
class WeatherController(private val service: WeatherService) {
    @GetMapping
    suspend fun getAll(): List<WeatherInfo> =
        service.getAll()

    @GetMapping("/city/{city}")
    suspend fun getForCity(@PathVariable city: String): List<WeatherInfo> =
        service.getForCity(city)
}
