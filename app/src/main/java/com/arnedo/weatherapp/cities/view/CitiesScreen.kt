package com.arnedo.weatherapp.cities.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.arnedo.weatherapp.R

@Composable
fun CitiesView(modifier: Modifier){
    Text(stringResource(R.string.cities_title))
}