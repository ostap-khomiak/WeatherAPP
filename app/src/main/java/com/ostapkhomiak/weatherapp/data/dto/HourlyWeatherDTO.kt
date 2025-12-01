package com.ostapkhomiak.weatherapp.data.dto

data class HourlyWeatherDTO(
    val dt: Long,
    val temp: Double,
    val weather: List<WeatherConditionDTO>
)