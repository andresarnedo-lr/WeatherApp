package com.arnedo.weatherapp.weather.domain

import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.entities.WeatherCity
import com.arnedo.weatherapp.common.utils.FormatUtils
import com.arnedo.weatherapp.common.utils.NetworkUtils
import com.arnedo.weatherapp.weather.model.LocalDatabase
import com.arnedo.weatherapp.weather.model.RemoteDatabase

class DataSource(
    private val rdb : RemoteDatabase,
    private val ldb : LocalDatabase,
    private val utils : NetworkUtils,
    private val formatUtils: FormatUtils
) {

    suspend fun getAllCities(onResult:(List<City>) -> Unit)
    = ldb.getAllCities{ onResult(it)}

    suspend fun searchWeatherByName(
        name: String,
        onResult : (WeatherCity?) -> Unit) {
        try {
            rdb.searchWeatherByName(name) { result ->
                onResult(
                    formatUtils.responseToWeatherCity(
                        result
                    )
                )
            }
        } catch (e: Exception) {
            onResult(null)
        }
    }

    suspend fun addWeatherAndCity(
        weatherCity: WeatherCity,
        onResult : (Boolean) -> Unit)
    = ldb.addWeatherAndCity(weatherCity){onResult(it)}

    suspend fun getWeatherByCity(city : City, onResult : (WeatherCity?) -> Unit) {
        try {
            if(utils.isOnline()){
//            rdb.searchWeatherByName(city.name){onResult(it)}
                rdb.getWeatherByCoordinates("${city.lat},${city.lon}" ){ result ->
                    onResult(formatUtils.responseToWeatherCity(result))}
            }else{
                ldb.getWeatherCityByCityId(city.id){onResult(it)}
            }
        }catch(e: Exception){
            onResult(null)
        }
    }
}