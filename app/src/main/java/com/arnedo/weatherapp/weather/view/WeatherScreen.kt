package com.arnedo.weatherapp.weather.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.arnedo.weatherapp.R
import com.arnedo.weatherapp.common.entities.WeatherCity
import com.arnedo.weatherapp.ui.components.MyCoilImage
import com.arnedo.weatherapp.ui.components.MyTextTitle
import com.arnedo.weatherapp.ui.theme.CommonPaddingDefault
import com.arnedo.weatherapp.ui.theme.CommonPaddingLarge
import com.arnedo.weatherapp.ui.theme.CommonPaddingMin
import com.arnedo.weatherapp.ui.theme.Typography
import com.arnedo.weatherapp.ui.theme.WeatherAppTheme
import com.arnedo.weatherapp.weather.viewmodel.WeatherViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherView(
    modifier: Modifier,
    vm : WeatherViewModel = koinViewModel()
    ){
    val uiState by vm.uiState.collectAsState()
    Box(modifier
        .fillMaxSize()
        .padding(top = CommonPaddingLarge), contentAlignment = Alignment.TopCenter){
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(CommonPaddingDefault)){
            MyTextTitle(R.string.weather_title)
            WeatherInfoView(uiState.data)

        }
    }
}

@Composable
private fun WeatherInfoView(weatherCity: WeatherCity){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "${weatherCity.temp_c.toInt()}º",
            style = Typography.displayLarge
        )
        Text(text = weatherCity.name,
            style = Typography.headlineLarge
        )
        Text(text = weatherCity.country,
            style = Typography.bodyLarge
        )

        MyCoilImage(url = weatherCity.iconHttps,
            modifier = Modifier
                .size(CommonPaddingLarge)
                .padding(top = CommonPaddingMin)
        )

        Text(text = weatherCity.description,
            style = Typography.headlineSmall,
            textAlign = TextAlign.Center
        )
        Text(text = "${weatherCity.wind_kph} km/h",
            style = Typography.bodyLarge
        )

    }
}




//
//@Preview(showBackground = true)
//@Composable
//private fun WeatherPreview(){
//    WeatherAppTheme {
//        WeatherView(Modifier)
//    }
//}

@Preview(showBackground = true)
@Composable
private fun WeatherInfoPreview(){
    WeatherAppTheme {
        WeatherInfoView(WeatherCity())
    }
}