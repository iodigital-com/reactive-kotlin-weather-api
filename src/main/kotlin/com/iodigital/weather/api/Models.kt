package com.iodigital.weather.api

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

@JvmRecord
data class Forecast(@JsonProperty("forecastday") val days: List<ForecastDay>)

@JvmRecord
data class ForecastDay(val date: LocalDate, @JsonProperty("day") val temperature: Temperature)

@JvmRecord
data class Location(@JsonProperty("name") val city: String, val region: String, val country: String)

@JvmRecord
data class Temperature(@JsonProperty("avgtemp_f") val avgF: Double)
