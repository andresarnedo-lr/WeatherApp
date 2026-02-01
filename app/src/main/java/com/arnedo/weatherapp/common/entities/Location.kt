package com.arnedo.weatherapp.common.entities

data class Location(
    val name: String = "",
    val country: String = "",
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val tz_id: String = ""

)

//"name": "London",
//"region": "City of London, Greater London",
//"country": "United Kingdom",
//"lat": 51.5171,
//"lon": -0.1062,
//"tz_id": "Europe/London",