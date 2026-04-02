package com.arnedo.weatherapp.weather.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudDownload
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arnedo.weatherapp.R
import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.entities.WeatherCity
import com.arnedo.weatherapp.ui.components.MyCoilImage
import com.arnedo.weatherapp.ui.components.MyDropDownMenu
import com.arnedo.weatherapp.ui.components.MyProgressFullScreen
import com.arnedo.weatherapp.ui.components.MySnackbar
import com.arnedo.weatherapp.ui.components.MyTextTitle
import com.arnedo.weatherapp.ui.theme.CommonPaddingDefault
import com.arnedo.weatherapp.ui.theme.CommonPaddingLarge
import com.arnedo.weatherapp.ui.theme.CommonPaddingMin
import com.arnedo.weatherapp.ui.theme.GlassBorder
import com.arnedo.weatherapp.ui.theme.GlassWhite
import com.arnedo.weatherapp.ui.theme.GradientDeepBlue
import com.arnedo.weatherapp.ui.theme.MessageVerticalSpace
import com.arnedo.weatherapp.ui.theme.TextSecondary
import com.arnedo.weatherapp.ui.theme.Typography
import com.arnedo.weatherapp.ui.theme.WeatherAppTheme
import com.arnedo.weatherapp.weather.viewmodel.WeatherUiState
import com.arnedo.weatherapp.weather.viewmodel.WeatherViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherView(
    modifier: Modifier,
    vm : WeatherViewModel = koinViewModel()
){
    val uiState by vm.uiState.collectAsState()
    val backgroundGradient = Brush.verticalGradient(colors = GradientDeepBlue)

    Box(modifier
        .fillMaxSize()
        .background(backgroundGradient)
        .padding(top = 32.dp), contentAlignment = Alignment.TopCenter){
        Column(
            modifier = Modifier.padding(horizontal = CommonPaddingDefault),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(CommonPaddingDefault)
        ){
            MyTextTitle(R.string.weather_title)
            
            WeatherInfoCard(uiState.data)
            
            ActionsView(
                uiState = uiState,
                onSelect = { city -> vm.getWeatherByCity(city) },
                onSave = { vm.saveWeatherCity(uiState.data) }
            )
            
            SearchView { name -> vm.searchWeather(name) }

            MySnackbar(modifier = Modifier
                .fillMaxWidth()
                .height(MessageVerticalSpace),
                msgRes = uiState.msgRes,
                onDismiss = { vm.clearMsg()})
        }
        MyProgressFullScreen(visible = uiState.inProgress)
    }
}

@Composable
private fun WeatherInfoCard(weatherCity: WeatherCity){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(GlassWhite, shape = RoundedCornerShape(28.dp))
            .border(1.dp, GlassBorder, RoundedCornerShape(28.dp))
            .padding(CommonPaddingLarge)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = weatherCity.name.ifBlank { "---" },
                style = Typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                color = Color.White
            )
            Text(
                text = weatherCity.country,
                style = Typography.bodyMedium,
                color = TextSecondary
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                MyCoilImage(
                    url = weatherCity.iconHttps,
                    modifier = Modifier.size(80.dp),
                    shape = RectangleShape
                )
                Text(
                    text = "${weatherCity.temp_c.toInt()}º",
                    style = Typography.displayLarge.copy(
                        fontSize = 72.sp,
                        fontWeight = FontWeight.Light
                    ),
                    color = Color.White
                )
            }

            Text(
                text = weatherCity.description.replaceFirstChar { it.uppercase() },
                style = Typography.titleLarge,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            
            if (weatherCity.wind_kph > 0) {
                Text(
                    text = "Viento: ${weatherCity.wind_kph} km/h",
                    style = Typography.bodyLarge,
                    color = TextSecondary,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun SearchView(onSearch: (String) -> Unit){
    var cityValue by remember { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(CommonPaddingMin),
        modifier = Modifier.fillMaxWidth()
    ){
        OutlinedTextField(
            value = cityValue,
            onValueChange = {cityValue = it},
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedBorderColor = Color.White,
                unfocusedBorderColor = GlassBorder,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = TextSecondary
            ),
            label = { Text(stringResource(R.string.cities_hint_search_city)) }
        )
        FilledIconButton(
            onClick = { onSearch(cityValue) },
            modifier = Modifier.size(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        }
    }
}

@Composable
private fun ActionsView(
    uiState : WeatherUiState,
    onSelect :(City) -> Unit,
    onSave:() -> Unit
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(CommonPaddingDefault),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(modifier = Modifier.weight(1f)) {
            MyDropDownMenu(
                items = uiState.items,
                labelRes = R.string.cities_city,
                onSelect= { city -> onSelect(city) }
            )
        }
        OutlinedIconButton(
            onClick = { onSave() },
            enabled = uiState.data.name.isNotBlank(),
            modifier = Modifier.size(56.dp),
            shape = RoundedCornerShape(16.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, if(uiState.data.name.isNotBlank()) Color.White else GlassBorder),
            colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White)
        ) {
            Icon(Icons.Default.CloudDownload, contentDescription = null)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeatherInfoPreview(){
    WeatherAppTheme {
        Box(modifier = Modifier.background(Brush.verticalGradient(GradientDeepBlue))) {
            WeatherInfoCard(WeatherCity(name = "Madrid", country = "España", temp_c = 25f, description = "Soleado"))
        }
    }
}
