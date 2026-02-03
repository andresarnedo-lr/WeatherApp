package com.arnedo.weatherapp.weather.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.arnedo.weatherapp.R
import com.arnedo.weatherapp.common.entities.WeatherCity
import com.arnedo.weatherapp.ui.components.MyCoilImage
import com.arnedo.weatherapp.ui.components.MyTextTitle
import com.arnedo.weatherapp.ui.theme.CommonPaddingDefault
import com.arnedo.weatherapp.ui.theme.CommonPaddingLarge
import com.arnedo.weatherapp.ui.theme.CommonPaddingMin
import com.arnedo.weatherapp.ui.theme.CommonPaddingXLarge
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
            SearchView { name ->
                vm.searchWeather(name)
            }

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
                .size(CommonPaddingXLarge)
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

@Composable
private fun SearchView(
    onSearch: (String) -> Unit,
    ){
    var cityValue by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(CommonPaddingMin)
        ){
        OutlinedTextField(
            value = cityValue,
            onValueChange = {cityValue = it},
            label = {
                Text(stringResource(R.string.cities_hint_search_city))
            })
        FilledIconButton(onClick = { onSearch(cityValue)}) {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        }
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
@Preview(showBackground = true)
@Composable
private fun SearchPreview(){
    WeatherAppTheme {
        SearchView(){}
    }
}