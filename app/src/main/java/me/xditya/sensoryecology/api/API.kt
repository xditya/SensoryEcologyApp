package me.xditya.sensoryecology.api

import me.xditya.sensoryecology.models.SensorData
import retrofit2.http.GET

interface ApiService {
    @GET("get")
    suspend fun getSensorData(): SensorData
}
