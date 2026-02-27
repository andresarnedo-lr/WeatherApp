package com.arnedo.weatherapp.weather.model

import com.arnedo.weatherapp.common.entities.WeatherCity
import com.arnedo.weatherapp.common.entities.WeatherResponse
import com.arnedo.weatherapp.common.utils.Constants
import com.arnedo.weatherapp.common.utils.FormatUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDatabase(
    private val service: WeatherService) {


    suspend fun searchWeatherByName(
        name: String,
        onResult : (WeatherResponse) -> Unit)
    = withContext(Dispatchers.IO){
            val result = service.searchWeatherByName(
                key = Constants.API_KEY,
                name = name,
                lang = Constants.LANG_ES)
            onResult(result)
    }
    suspend fun getWeatherByCoordinates(
        coordinates: String,
        onResult : (WeatherResponse) -> Unit)
    = withContext(Dispatchers.IO){
            val result = service.getWeatherByCoordinates(
                key = Constants.API_KEY,
                coordinates = coordinates,
                lang = Constants.LANG_ES)
            onResult(result)
    }
}