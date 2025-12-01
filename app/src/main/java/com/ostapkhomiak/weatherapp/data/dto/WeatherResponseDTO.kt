package com.ostapkhomiak.weatherapp.data.dto

import com.ostapkhomiak.weatherapp.domain.model.HourWeather
import com.ostapkhomiak.weatherapp.domain.model.Weather
import java.text.SimpleDateFormat

data class WeatherResponseDTO(
    val current: CurrentWeatherDTO,
    val hourly: List<HourlyWeatherDTO>
)


fun WeatherResponseDTO.toDomain(): Weather {
    val first = hourly.firstOrNull() // use first forecast as current
    return Weather(
        temperature = first?.temp ?: 0.0,
        iconUrl = first?.weather?.firstOrNull()?.icon?.let { "https://openweathermap.org/img/wn/$it@4x.png" } ?: "",
        hours = hourly.take(24).map {
            HourWeather(
                time = SimpleDateFormat("HH:mm").format(it.dt * 1000),
                temp = it.temp,
                iconUrl = "https://openweathermap.org/img/wn/${it.weather.first().icon}.png"
            )
        }
    )
}
