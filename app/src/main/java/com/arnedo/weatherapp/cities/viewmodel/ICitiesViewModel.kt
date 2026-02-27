package com.arnedo.weatherapp.cities.viewmodel

import com.arnedo.weatherapp.common.entities.City
import kotlinx.coroutines.flow.StateFlow

interface ICitiesViewModel {
    fun getUiState(): StateFlow<CityUiState>
    fun showMap(city: City)
    fun clearMsg()
    fun deleteCity(city: City)
}
