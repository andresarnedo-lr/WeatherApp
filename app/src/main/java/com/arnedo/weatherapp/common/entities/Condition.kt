package com.arnedo.weatherapp.common.entities

data class Condition(
    val text: String = "",
    val icon: String = "",
){
    val iconHttps get() = "https:$icon"
}


//
//"text": "Overcast",
//"icon": "//cdn.weatherapi.com/weather/64x64/night/122.png",