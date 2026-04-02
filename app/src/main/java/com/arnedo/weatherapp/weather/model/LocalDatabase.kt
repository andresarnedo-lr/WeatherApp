package com.arnedo.weatherapp.weather.model

import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.entities.Weather
import com.arnedo.weatherapp.common.entities.WeatherCity
import com.arnedo.weatherapp.common.model.CityDao
import com.arnedo.weatherapp.common.model.WeatherCityDao
import com.arnedo.weatherapp.common.model.WeatherDao
import com.arnedo.weatherapp.common.utils.FormatUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class LocalDatabase(
    private val cityDao: CityDao,
    private val weatherDao : WeatherDao,
    private val  utils: FormatUtils,
    private val weatherCityDao: WeatherCityDao
) {
    fun getAllCitiesRealtime(): Flow<List<City>> = cityDao.getAllCitiesRealtime()

    suspend fun getAllCities(onResult:(List<City>) -> Unit) = withContext(Dispatchers.IO){
        onResult(cityDao.getAllCities())
    }

    suspend fun addWeatherAndCity(
        weatherCity: WeatherCity,
        onResult : (Boolean) -> Unit
        )= withContext(Dispatchers.IO){
            val city = utils.weatherCityToCity(weatherCity)
            val weather = utils.weatherCityToWeather(weatherCity)
            val result = weatherCityDao.addCityAndWeather(city, weather)
        onResult(result > 0)
    }

    suspend fun getWeatherCityByCityId(
        cityId: Long,
        onResult: (WeatherCity?) -> Unit) =
        withContext(Dispatchers.IO) {
            onResult(weatherDao.getWeatherCityByCityId(cityId))
    }
}