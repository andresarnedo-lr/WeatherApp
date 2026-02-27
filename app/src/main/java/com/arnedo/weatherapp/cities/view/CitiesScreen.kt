package com.arnedo.weatherapp.cities.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arnedo.weatherapp.R
import com.arnedo.weatherapp.cities.viewmodel.CitiesViewModel
import com.arnedo.weatherapp.ui.components.MyProgressFullScreen
import com.arnedo.weatherapp.ui.components.MyTextTitle
import com.arnedo.weatherapp.ui.theme.WeatherAppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun CitiesView(
    modifier: Modifier,
    vm : CitiesViewModel = koinViewModel()) {
    val uiState by vm.getUiState().collectAsState()
    Box(modifier.fillMaxSize()) {
        Column {
            MyTextTitle(R.string.cities_title)
            LazyColumn {
                items(uiState.items.size) { index ->
                    val city = uiState.items[index]
                    ItemCityView(city)
                }
            }
            MyProgressFullScreen(visible = false)
        }
    }
}
@Preview(showSystemUi = true,showBackground = true)
@Composable
fun CitiesPreview(){
    WeatherAppTheme{
        CitiesView(Modifier.padding(top = 24.dp))
    }
}