package com.arnedo.weatherapp.cities.viewmodel

import com.arnedo.weatherapp.R
import com.arnedo.weatherapp.common.entities.City

data class CityUiState(
    val items : List<City> = emptyList(),
    val inProgress : Boolean = false,
    val msgRes : Int = R.string.msg_empty
)