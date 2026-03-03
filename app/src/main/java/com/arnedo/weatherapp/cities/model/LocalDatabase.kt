package com.arnedo.weatherapp.cities.model

import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.model.CityDao
import com.arnedo.weatherapp.common.model.WeatherCityDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class LocalDatabase(
    private val cityDao: CityDao,
    private val weatherCityDao: WeatherCityDao
) {
    fun getAllCitiesRealtime(): Flow<List<City>> = cityDao.getAllCitiesRealtime()

    suspend fun deleteCityAndWeather(
        city: City,
        onResult: (Boolean) -> Unit
    ) = withContext(Dispatchers.IO) {
        onResult(weatherCityDao.deleteCityAndWeather(city) > 0)
    }
}