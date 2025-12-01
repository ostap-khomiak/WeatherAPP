package com.ostapkhomiak.weatherapp.data.remote


import com.ostapkhomiak.weatherapp.data.dto.GeoResultDTO
import com.ostapkhomiak.weatherapp.data.dto.WeatherResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {
    @GET("data/3.0/onecall")
    suspend fun getWeatherByCoordinates(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherResponseDTO

    @GET("geo/1.0/direct")
    suspend fun getCoordinatesByCityName(
        @Query("q") cityName: String,
        @Query("limit") limit: Int = 5,
        @Query("appid") apiKey: String
    ): List<GeoResultDTO>
}
