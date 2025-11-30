package com.ostapkhomiak.weatherapp.domain.model



data class HoursWeather (
    val time: String,   // "14:00"
    val temperature: Double,
    val icon: Int // image
)