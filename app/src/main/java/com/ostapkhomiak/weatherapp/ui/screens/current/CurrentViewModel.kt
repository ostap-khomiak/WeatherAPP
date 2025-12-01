package com.ostapkhomiak.weatherapp.ui.screens.current


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ostapkhomiak.weatherapp.data.repository.WeatherRepository
import kotlinx.coroutines.launch



class CurrentViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    var state = mutableStateOf(CurrentState())
        private set

    fun loadWeather(lat: Double, lon: Double) {
        state.value = state.value.copy(isLoading = true,)

        viewModelScope.launch {
            try {
                val weather = repository.getForecast(lat, lon)
                state.value = state.value.copy(
                    isLoading = false,
                    weather = weather,
                )
            } catch (e: Exception) {
                state.value = state.value.copy(
                    isLoading = false,
                    error = e.message,
                )
            }
        }
    }

    fun searchCity(cityName: String) {
        state.value = state.value.copy(isLoading = true,)

        viewModelScope.launch {
            try {
                val geoResults = repository.getCoordinatesForCity(cityName)

                if (geoResults.isEmpty()) {
                    state.value = state.value.copy(
                        isLoading = false,
                        error = "City not found",
                    )
                    return@launch
                }


                val firstResult = geoResults.first()
                val weather = repository.getForecast(firstResult.lat, firstResult.lon)


                state.value = state.value.copy(
                    isLoading = false,
                    weather = weather,
                    cityName = "${firstResult.name}, ${firstResult.country}"
                )
            } catch (e: Exception) {
                state.value = state.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to search city",
                )
            }
        }
    }
}