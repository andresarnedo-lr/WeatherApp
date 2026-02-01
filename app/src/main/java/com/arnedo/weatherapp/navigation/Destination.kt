package com.arnedo.weatherapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.ui.graphics.vector.ImageVector
import com.arnedo.weatherapp.R
import com.arnedo.weatherapp.utils.Constants

enum class Destination(
    val route: String,
    val labelRes : Int,
    val icon : ImageVector
) {
    WEATHER(Constants.NAV_WEATHER, R.string.weather_title, Icons.Default.WbSunny),
    CITIES(Constants.NAV_CITIES, R.string.cities_title, Icons.Default.LocationCity)

}