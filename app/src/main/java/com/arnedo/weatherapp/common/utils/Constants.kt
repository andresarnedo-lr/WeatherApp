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

    //Components
    const val DURATION_SHORT = 3_000L
    const val DURATION_LONG = 8_000L

    //ROOM
    const val DB_NAME = "db_wheater_app"
    const val DB_INIT_VERSION = 1
    //E = Entitiy
    const val E_CITY = "city_entity"
    const val E_WEATHER = "city_weather"
    // P = Property
    const val P_NAME = "name"
    const val P_COUNTRY = "country"
    const val P_CITY_ID = "cityId"


}