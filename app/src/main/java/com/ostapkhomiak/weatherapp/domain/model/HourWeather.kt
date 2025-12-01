package com.ostapkhomiak.weatherapp.domain.model



data class HourWeather(
    val time: String,  // "13:00"
    val temp: Double,
    val iconUrl: String
)