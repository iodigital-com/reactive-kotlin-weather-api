package com.iodigital.weather.api

import com.iodigital.weather.WeatherInfo

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
