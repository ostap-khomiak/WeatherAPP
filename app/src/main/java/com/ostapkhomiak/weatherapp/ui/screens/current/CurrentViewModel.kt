package com.ostapkhomiak.weatherapp.ui.screens.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ostapkhomiak.weatherapp.R
import com.ostapkhomiak.weatherapp.domain.model.HoursWeather
import com.ostapkhomiak.weatherapp.domain.model.Weather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CurrentViewModel : ViewModel() {  // repository

    private val _state = MutableStateFlow(CurrentState())
    val state: StateFlow<CurrentState> = _state

    fun loadWeather() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)

            val fakeWeather = Weather(  // test
                temperature = 23.5,
                icon = R.drawable.ic_launcher_foreground,
                hours = List(12) {
                    HoursWeather(
                        time = "${10 + it}:00",
                        temperature = 20 + it.toDouble(),
                        icon = R.drawable.ic_launcher_foreground
                    )
                }
            )

            _state.value = CurrentState(weather = fakeWeather)
        }
    }
}