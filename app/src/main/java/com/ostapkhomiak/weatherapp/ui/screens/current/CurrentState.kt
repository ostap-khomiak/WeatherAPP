package com.ostapkhomiak.weatherapp.ui.screens.current


import com.ostapkhomiak.weatherapp.domain.model.Weather


data class CurrentState(
    val isLoading: Boolean = false,
    val weather: Weather? = null,
    val error: String? = null,
    val cityName: String? = null
)