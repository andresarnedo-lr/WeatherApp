package com.arnedo.weatherapp.cities.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arnedo.weatherapp.R
import com.arnedo.weatherapp.cities.viewmodel.CitiesViewModel
import com.arnedo.weatherapp.cities.viewmodel.CityUiState
import com.arnedo.weatherapp.cities.viewmodel.ICitiesViewModel
import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.model.getAllCityPreview
import com.arnedo.weatherapp.ui.components.MyDialogInfo
import com.arnedo.weatherapp.ui.components.MyProgressFullScreen
import com.arnedo.weatherapp.ui.components.MyTextTitle
import com.arnedo.weatherapp.ui.theme.WeatherAppTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.androidx.compose.koinViewModel

@Composable
fun CitiesView(
    modifier: Modifier,
    vm : ICitiesViewModel = koinViewModel<CitiesViewModel>()) {
    val uiState by vm.getUiState().collectAsState()
    var openDialog by remember { mutableStateOf(false) }
    var selectedCity by remember {mutableStateOf<City?>(null)}

    Box(modifier.fillMaxSize()) {
        Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            MyTextTitle(R.string.cities_title)
            LazyColumn {
                items(uiState.items.size) { index ->
                    val city = uiState.items[index]
                    ItemCityView(
                        city = city,
                        onMap = { vm.showMap(city) },
                        onRemove = { city ->
                            selectedCity = city
                            openDialog = true
                        }
                        )
                }
            }
            if(openDialog){
                selectedCity?.let{ city ->
                    MyDialogInfo(
                        infoRes = R.string.dialog_msg_warning,
                        titleRes = R.string.dialog_delete_title,
                        confirmRes = R.string.dialog_delete_confirm){ isDeleted ->
                            if(isDeleted) vm.deleteCity(city)
                            openDialog = false
                        }
                }
            }
            MyProgressFullScreen(visible = uiState.inProgress)
        }
    }
}
@Preview(showSystemUi = true,showBackground = true)
@Composable
fun CitiesPreview(){
    WeatherAppTheme{
        CitiesView(Modifier.padding(top = 24.dp),
        vm = CitiesVmPreview())

    }
}

private class CitiesVmPreview: ICitiesViewModel {
    override fun getUiState() = MutableStateFlow(CityUiState(getAllCityPreview()))
    override fun showMap(city: City){}
    override fun clearMsg(){}
    override fun deleteCity(city: City){}
}