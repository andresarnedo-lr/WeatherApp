package com.arnedo.weatherapp.common.model

import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.entities.Condition
import com.arnedo.weatherapp.common.entities.Current
import com.arnedo.weatherapp.common.entities.Weather
import com.arnedo.weatherapp.common.entities.WeatherCity
import com.arnedo.weatherapp.common.entities.WeatherResponse

/**
 * Project: DI Basics
 * From: com.cursosant.dibasics
 * Created by: Alain Nicolás Tello.
 * On: 01/08/25 at 08:51
 * All rights reserved 2025.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * And Frogames formación:
 * https://cursos.frogamesformacion.com/pages/instructor-alain-nicolas
 *
 * Coupons on my Website:
 * www.alainnicolastello.com
 */

val cityPreview = City(0,"Lima", "Perú", 1.2118, -2.1921)

fun getAllCityPreview() = listOf(
    City(0,"Cdmx", "México", 19.4334565, -99.1331708),
    City(0,"Madrid", "España", 40.416775, -3.703790),
    cityPreview
)


val weatherCityPreview = WeatherCity(
    31f, "Vientos fuertes",
    22.5f, "","Lima", "Perú"
)

fun getAllWeatherCityPreview() = listOf(
    WeatherCity(
        21f, "Nublado",
        12.5f, "","CDMX", "México"
    ),
    WeatherCity(
        21f, "Soleado",
        6f, "","Madrid", "España"
    ),
    weatherCityPreview
)

//Testing
val weatherTest = Weather(
    id = 1,
    temp_c = 10f,
    iconHttps = "https://cdn.weatherapi.com/weather/64x64/day/116.png",
    description = "Templado",
    wind_kph = 8f,
    cityId = 1
)

val weatherResponseTest = WeatherResponse(
    location = City(
        name = "Málaga",
        country = "España",
        lat = 36.72016,
        lon = -4.42034
    ),
    current = Current(
        temp_c = 29f,
        condition = Condition(
            text = "Parcialmente nublado.",
            icon = "//cdn.weatherapi.com/weather/64x64/day/116.png"
        ),
        wind_kph = 13.2f
    )
)

val weatherResponseNullIslandTest = WeatherResponse(
    location = City(
        name = "Isla Nula",
        country = "N/A",
        lat = 0.0,
        lon = 0.0
    ),
    current = Current(
        temp_c = 29f,
        condition = Condition(
            text = "Parcialmente nublado.",
            icon = "//cdn.weatherapi.com/weather/64x64/day/116.png"
        ),
        wind_kph = 13.2f
    )
)

val weatherCityTest = WeatherCity(
    temp_c = 29f,
    iconHttps = "https://cdn.weatherapi.com/weather/64x64/day/116.png",
    description="Parcialmente nublado.",
    wind_kph=13.2f,
    name="Málaga",
    country="España",
    lat=36.72016,
    lon=-4.42034)

val cityNullIslandTest = City(id = 1, name = "Isla Nula", country = "N/A", lat = 0.0, lon = 0.0)

val weatherCityNullIslandTest = weatherCityTest.copy(name = "Isla Nula", country = "N/A", lat = 0.0, lon = 0.0)
