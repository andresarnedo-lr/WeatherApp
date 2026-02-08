package com.arnedo.weatherapp.weather.model

import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.entities.WeatherCity
import com.arnedo.weatherapp.common.model.CityDao
import com.arnedo.weatherapp.common.utils.FormatUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDatabase(
    private val cityDao: CityDao,
    private val  utils: FormatUtils
) {
    suspend fun getAllCities(onResult:(List<City>) -> Unit) = withContext(Dispatchers.IO){
        onResult(cityDao.getAllCities())
    }

    suspend fun addWeatherAndCity(
        weatherCity: WeatherCity,
        onResult : (Boolean) -> Unit
        )= withContext(Dispatchers.IO){
            val city = utils.weatherCityToCity(weatherCity)
            val result = cityDao.addCity(city)
        onResult(result > 0)

    }
}