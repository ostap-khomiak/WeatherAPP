package com.ostapkhomiak.weatherapp.domain.model



data class Weather (
    val temperature: Double,
    val icon: Int, // image
    val hours: List<HoursWeather>
)