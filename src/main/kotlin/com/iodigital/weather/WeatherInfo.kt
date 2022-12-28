package com.iodigital.weather

import org.springframework.data.annotation.Id
import java.time.LocalDate

class WeatherInfo(
    @Id
    var id: Long? = null,
    var region: String? = null,
    var country: String? = null,
    var state: String? = null,
    var city: String? = null,
    var localDate: LocalDate? = null,
    var avgTemperature: String? = null
)
