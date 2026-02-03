package com.arnedo.weatherapp.weather.model

import com.arnedo.weatherapp.common.entities.WeatherCity
import com.arnedo.weatherapp.common.utils.Constants
import com.arnedo.weatherapp.common.utils.FormatUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDatabase(
    private val service: WeatherService,
    private val utils : FormatUtils) {


    suspend fun searchWeatherByName(
        name: String,
        onResult : (WeatherCity?) -> Unit)
    = withContext(Dispatchers.IO){
        try {
            val result = service.searchWeatherByName(
                key = Constants.API_KEY,
                name = name,
                lang = Constants.LANG_ES
            )
            onResult(utils.responseToWeatherCity(result))
        }catch(e: Exception){
            onResult(null)
        }
    }
}