package com.ostapkhomiak.weatherapp.domain.model



data class Weather(
    val temperature: Double,
    val iconUrl: String,
    val hours: List<HourWeather>
)