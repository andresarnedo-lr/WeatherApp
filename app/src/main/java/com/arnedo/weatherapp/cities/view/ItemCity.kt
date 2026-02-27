package com.arnedo.weatherapp.cities.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowOutward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.model.cityPreview
import com.arnedo.weatherapp.ui.theme.CommonPaddingMin
import com.arnedo.weatherapp.ui.theme.Typography
import com.arnedo.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun ItemCityView(city: City){
    Card(modifier = Modifier.padding(CommonPaddingMin)) {
        Row{
            Text(text = city.toString(),
                modifier = Modifier
                    .weight(1f)
                    .padding(CommonPaddingMin),
                style = Typography.headlineSmall
            )
            IconButton(onClick = {}) {
                Icon(Icons.Default.ArrowOutward, contentDescription = null)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemCityPreview(){
    WeatherAppTheme() {
        ItemCityView(cityPreview)
    }
}