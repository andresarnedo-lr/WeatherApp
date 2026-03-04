package com.arnedo.weatherapp.cities.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arnedo.weatherapp.R
import com.arnedo.weatherapp.cities.viewmodel.CitiesViewModel
import com.arnedo.weatherapp.cities.viewmodel.CityUiState
import com.arnedo.weatherapp.cities.viewmodel.ICitiesViewModel
import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.model.getAllCityPreview
import com.arnedo.weatherapp.ui.components.MyCoilImage
import com.arnedo.weatherapp.ui.components.MyDialogInfo
import com.arnedo.weatherapp.ui.components.MyProgressFullScreen
import com.arnedo.weatherapp.ui.components.MySnackbar
import com.arnedo.weatherapp.ui.components.MyTextTitle
import com.arnedo.weatherapp.ui.theme.CommonPaddingDefault
import com.arnedo.weatherapp.ui.theme.GradientDeepBlue
import com.arnedo.weatherapp.ui.theme.WeatherAppTheme
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.androidx.compose.koinViewModel

@Composable
fun CitiesView(
    modifier: Modifier,
    vm : ICitiesViewModel = koinViewModel<CitiesViewModel>()) {
    val uiState by vm.getUiState().collectAsState()
    var openDialog by remember { mutableStateOf(false) }
    var selectedCity by remember {mutableStateOf<City?>(null)}
    val backgroundGradient = Brush.verticalGradient(colors = GradientDeepBlue)

    Box(modifier.fillMaxSize().background(backgroundGradient)) {
        Column(
            modifier = Modifier.padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyTextTitle(R.string.cities_title)
            Spacer(modifier = Modifier.height(16.dp))
            
            if(uiState.items.isEmpty()){
                Box(modifier = Modifier.fillMaxSize().padding(CommonPaddingDefault), contentAlignment = Alignment.Center) {
                    MyCoilImage(
                        url = "https://images.adsttc.com/media/images/62cc/3521/c0d4/a362/5a77/fd0d/medium_jpg/las-10-ciudades-mas-grandes-de-latinoamerica-en-20222_1.jpg?1657550121",
                        modifier = Modifier.fillMaxWidth().height(240.dp),
                        shape = RoundedCornerShape(28.dp),
                    )
                }
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(uiState.items.size) { index ->
                        val city = uiState.items[index]
                        ItemCityView(
                            city = city,
                            onMap = { vm.showMap(city) },
                            onRemove = { cityToDelete ->
                                selectedCity = cityToDelete
                                openDialog = true
                            }
                        )
                    }
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

            MySnackbar(
                modifier = Modifier.fillMaxWidth().padding(CommonPaddingDefault),
                msgRes = uiState.msgRes,
                colorBackground = Color.White.copy(alpha = 0.9f),
                shape = RoundedCornerShape(16.dp),
                onDismiss = { vm.clearMsg() }
            )

            MyProgressFullScreen(visible = uiState.inProgress)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CitiesPreview(){
    WeatherAppTheme{
        CitiesView(Modifier, vm = CitiesVmPreview())
    }
}

private class CitiesVmPreview: ICitiesViewModel {
    override fun getUiState() = MutableStateFlow(CityUiState(getAllCityPreview()))
    override fun showMap(city: City){}
    override fun clearMsg(){}
    override fun deleteCity(city: City){}
}
