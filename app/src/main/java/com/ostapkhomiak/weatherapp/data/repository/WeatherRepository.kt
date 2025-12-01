package com.ostapkhomiak.weatherapp.data.repository


import com.ostapkhomiak.weatherapp.data.dto.GeoResultDTO
import com.ostapkhomiak.weatherapp.data.dto.toDomain
import com.ostapkhomiak.weatherapp.data.remote.OpenWeatherApi
import com.ostapkhomiak.weatherapp.domain.model.Weather


class WeatherRepository(
    private val api: OpenWeatherApi,
    private val apiKey: String
) {

    suspend fun getForecast(lat: Double, lon: Double): Weather {
        val result = api.getWeatherByCoordinates(lat, lon, apiKey)
        return result.toDomain()
    }

    suspend fun getCoordinatesForCity(cityName: String): List<GeoResultDTO> {
        return api.getCoordinatesByCityName(cityName, 5, apiKey)
    }

}