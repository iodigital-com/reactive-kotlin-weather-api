package com.iodigital.weather

import com.iodigital.weather.api.WeatherAPIClient
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class WeatherService(
    private val api: WeatherAPIClient,
    private val repository: WeatherRepository
) {
    fun getAll(): Flux<WeatherInfo> =
        repository.findAll()

    fun getForCity(city: String): Flux<WeatherInfo> =
        repository
            .findAllByCityIgnoreCase(city)
            .switchIfEmpty(
                api
                    .getWeather(city)
                    .flatMapMany { repository.saveAll(it.toWeatherInfoList()) }
            )
}
