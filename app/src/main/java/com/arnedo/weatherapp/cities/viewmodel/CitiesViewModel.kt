package com.arnedo.weatherapp.cities.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arnedo.weatherapp.R
import com.arnedo.weatherapp.cities.model.LocalDatabase
import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.utils.IntentUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CitiesViewModel(
    private val db: LocalDatabase,
    private val utils: IntentUtils
) : ViewModel(), ICitiesViewModel {

    private val _uiState = MutableStateFlow(CityUiState())
    override fun getUiState(): StateFlow<CityUiState> = _uiState.asStateFlow()

    init {
        getAllCities()
    }

    private fun getAllCities() {
        viewModelScope.launch {
            _uiState.update { it.copy(inProgress = true) }
            db.getAllCities { result ->
                if (result.isNotEmpty()) {
                    _uiState.update { it.copy(items = result) }
                } else {
                    _uiState.update { it.copy(msgRes = R.string.cities_empty_list) }
                }
                _uiState.update { it.copy(inProgress = false) }
            }
        }
    }

    override fun showMap(city: City) {
        utils.showMap(city.lat, city.lon, city.name)
    }

    override fun clearMsg() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(msgRes = R.string.msg_empty)
            }
        }
    }

    override fun deleteCity(city: City) {

    }
}
