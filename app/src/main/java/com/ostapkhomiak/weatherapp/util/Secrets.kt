package com.ostapkhomiak.weatherapp.util

import android.util.Log
import com.ostapkhomiak.weatherapp.BuildConfig
import java.io.File
import java.io.FileInputStream
import java.util.Properties

object Secrets {
    private const val LOCAL_PROPERTIES_FILE = "local.properties"

    init {

        loadProperties()
    }

    private fun loadProperties() {
        try {
            val properties = Properties()
            val localProperties = File(LOCAL_PROPERTIES_FILE)
            if (localProperties.exists()) {
                properties.load(FileInputStream(localProperties))
            } else {
                // For CI/CD
                properties["API_KEY"] = System.getenv("API_KEY") ?: ""
            }
        } catch (e: Exception) {
            Log.e("Secrets", "Error loading properties", e)
        }
    }

    fun getApiKey(): String {
        return BuildConfig.API_KEY
    }
}