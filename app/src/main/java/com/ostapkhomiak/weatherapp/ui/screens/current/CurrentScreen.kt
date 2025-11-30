package com.ostapkhomiak.weatherapp.ui.screens.current


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ostapkhomiak.weatherapp.domain.model.Weather
import com.ostapkhomiak.weatherapp.ui.components.WeatherItem


@Composable
fun CurrentScreen(
    viewModel: CurrentViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadWeather()
    }

    when {
        state.isLoading -> LoadingScreen()
        state.error != null -> ErrorScreen(state.error!!)
        else -> state.weather?.let { weather ->
            WeatherContent(weather)
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) { CircularProgressIndicator() }
}

@Composable
fun ErrorScreen(text: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) { Text("Error: $text") }
}

@Composable
fun WeatherContent(weather: Weather) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Image(
            painter = painterResource(id = weather.icon),
            contentDescription = null,
            modifier = Modifier.size(140.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "${weather.temperature}°C",
            fontSize = 48.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(weather.hours) { hour ->
                WeatherItem(hour)
            }
        }
    }
}

