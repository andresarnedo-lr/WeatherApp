package com.arnedo.weatherapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.arnedo.weatherapp.R
import com.arnedo.weatherapp.ui.theme.ProgressBackground
import com.arnedo.weatherapp.ui.theme.WeatherAppTheme

@Preview
@Composable
private fun MyProgressPreview() {
    WeatherAppTheme() {
        MyProgressFullScreen()
    }
}


@Composable
fun MyProgressFullScreen() {
    Box(Modifier
        .fillMaxSize()
        .background(ProgressBackground)
        .clickable(interactionSource = null , indication = null){},
        contentAlignment = Alignment.Center){
        CircularProgressIndicator()
    }
}