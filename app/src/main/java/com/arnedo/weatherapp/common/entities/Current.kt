package com.arnedo.weatherapp.common.entities

data class Current(
    val temp_c: Float = 0f,
    val is_day: Int = 0,
    val condition: Condition = Condition(),
    val wind_kph: Float = 0f
)


//"temp_c": 8.1,
//"temp_f": 46.6,
//"is_day": 0,
//"condition": {
//    "text": "Overcast",
//    "icon": "//cdn.weatherapi.com/weather/64x64/night/122.png",
//    "code": 1009
//},
//"wind_mph": 3.8,
//"wind_kph": 6.1,