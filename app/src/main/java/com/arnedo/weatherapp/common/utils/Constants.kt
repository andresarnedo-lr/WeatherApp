package com.arnedo.weatherapp.common.utils

//https://api.weatherapi.com/v1/current.json?key=913410e0b77948ec8c7183850260102&q=London&aqi=no
object Constants {
    //Navigation
    const val NAV_WEATHER = "nav_weather"
    const val NAV_CITIES = "nav_cities"

    //Retrofit
    const val BASE_URL = "https://api.weatherapi.com"
    const val PATH_V1 = "/v1/current.json"

    const val PARAM_KEY = "key"
    const val PARAM_QUERY = "q"
    const val PARAM_LANGUAGE = "lang"

    const val API_KEY = "913410e0b77948ec8c7183850260102"
    const val LANG_ES = "es"

}