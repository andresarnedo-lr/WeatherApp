package com.arnedo.weatherapp.common.model

import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.entities.WeatherCity

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