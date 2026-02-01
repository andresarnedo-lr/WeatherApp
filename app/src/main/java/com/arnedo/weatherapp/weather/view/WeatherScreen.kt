package com.arnedo.weatherapp.weather.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.arnedo.weatherapp.R

@Composable
fun WeatherView(modifier: Modifier){
    Text(stringResource(R.string.weather_title))
}