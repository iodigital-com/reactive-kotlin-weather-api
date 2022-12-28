package com.iodigital.weather.api

import com.fasterxml.jackson.annotation.JsonProperty
import com.iodigital.weather.WeatherInfo
import java.time.LocalDate

@JvmRecord
data class Forecast(@JsonProperty("forecastday") val days: List<ForecastDay>)

@JvmRecord
data class ForecastDay(val date: LocalDate, @JsonProperty("day") val temperature: Temperature)

@JvmRecord
data class Location(@JsonProperty("name") val city: String, val region: String, val country: String)

@JvmRecord
data class Temperature(@JsonProperty("avgtemp_f") val avgF: Double)

@JvmRecord
data class WeatherAPIResponse(val location: Location, val forecast: Forecast) {
    fun toWeatherInfoList(): List<WeatherInfo> =
        forecast.days.map {
            WeatherInfo(
                id = null,
                region = location.region,
                country = location.country,
                state = "",
                city = location.city,
                localDate = it.date,
                avgTemperature = "%.2f".format(it.temperature.avgF)
            )
        }
}
