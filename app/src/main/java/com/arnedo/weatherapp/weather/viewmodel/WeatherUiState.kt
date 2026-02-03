package com.arnedo.weatherapp.weather.viewmodel

import com.arnedo.weatherapp.R
import com.arnedo.weatherapp.common.entities.WeatherCity

data class WeatherUiState(
    val data : WeatherCity = WeatherCity(),
    val inProgress : Boolean = false,
    val msgRes : Int = R.string.msg_empty
    )
