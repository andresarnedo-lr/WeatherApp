package com.arnedo.weatherapp.weather.model

import com.arnedo.weatherapp.common.entities.WeatherCity
import com.arnedo.weatherapp.common.utils.Constants
import com.arnedo.weatherapp.common.utils.FormatUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDatabase(
    private val service: WeatherService? = null,
    private val utils : FormatUtils) {
    private fun setupRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun weatherService() : WeatherService {
        return setupRetrofit().create(WeatherService::class.java)
    }

    suspend fun searchWeatherByName(
        name: String,
        onResult : (WeatherCity?) -> Unit)
    = withContext(Dispatchers.IO){
        try {
            val result = weatherService().searchWeatherByName(
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