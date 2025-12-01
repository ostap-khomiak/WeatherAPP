package com.ostapkhomiak.weatherapp.data.dto

data class CurrentWeatherDTO(
    val temp: Double,
    val weather: List<WeatherConditionDTO>
)