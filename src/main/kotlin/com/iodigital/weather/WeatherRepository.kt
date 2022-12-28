package com.iodigital.weather

import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WeatherRepository : CoroutineCrudRepository<WeatherInfo, Long> {
    suspend fun findAllByCityIgnoreCase(city: String): Flow<WeatherInfo>
}
