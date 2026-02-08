package com.arnedo.weatherapp.common.entities

data class WeatherResponse(
    val location : City = City(),
    val current : Current = Current()
)
