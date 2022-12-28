package com.iodigital.weather

import com.iodigital.weather.api.WeatherAPIClient
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class WeatherService(
    private val api: WeatherAPIClient,
    private val repository: WeatherRepository
) {
    suspend fun getAll(): List<WeatherInfo> =
        repository.findAll().toList()

    suspend fun getForCity(city: String): List<WeatherInfo> =
        repository
            .findAllByCityIgnoreCase(city)
            .toList()
            .takeIf { it.isNotEmpty() }
            ?: api
                .getWeather(city)
                .let { repository.saveAll(it.toWeatherInfoList()).toList() }
}
