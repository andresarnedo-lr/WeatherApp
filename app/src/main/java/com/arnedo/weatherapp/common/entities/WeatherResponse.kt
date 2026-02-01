package com.arnedo.weatherapp.common.entities

data class WeatherResponse(
    val location : Location = Location(),
    val current : Current = Current()
)
