package com.ostapkhomiak.weatherapp.ui.navigation

sealed class Screen(val route: String) {
    object Current : Screen("current")
    object Forecast : Screen("forecast")
    object Settings : Screen("settings")
}