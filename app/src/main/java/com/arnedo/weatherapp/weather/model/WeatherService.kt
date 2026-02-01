package com.arnedo.weatherapp.weather.model

import com.arnedo.weatherapp.common.entities.WeatherResponse
import com.arnedo.weatherapp.common.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET(Constants.PATH_V1)
    suspend fun searchWeatherByName(
        @Query(Constants.PARAM_KEY) key: String,
        @Query(Constants.PARAM_QUERY) name: String,
        @Query(Constants.PARAM_LANGUAGE) lang: String
    ) : WeatherResponse
}