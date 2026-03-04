package com.arnedo.weatherapp.cities.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Map
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.model.cityPreview
import com.arnedo.weatherapp.ui.theme.CommonPaddingDefault
import com.arnedo.weatherapp.ui.theme.CommonPaddingMin
import com.arnedo.weatherapp.ui.theme.GlassBorder
import com.arnedo.weatherapp.ui.theme.GlassWhite
import com.arnedo.weatherapp.ui.theme.GradientDeepBlue
import com.arnedo.weatherapp.ui.theme.TextSecondary
import com.arnedo.weatherapp.ui.theme.Typography
import com.arnedo.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun ItemCityView(
    city: City,
    onMap: (City) -> Unit,
    onRemove: (City) -> Unit
){
    val swipeToDismissBoxState = rememberSwipeToDismissBoxState(
        confirmValueChange = {
            if(it == SwipeToDismissBoxValue.EndToStart) {
                onRemove(city)
            }
            it != SwipeToDismissBoxValue.EndToStart
        }
    )

    SwipeToDismissBox(
        state = swipeToDismissBoxState,
        modifier = Modifier.padding(horizontal = CommonPaddingDefault, vertical = CommonPaddingMin),
        enableDismissFromStartToEnd = false,
        backgroundContent = {
            val color = if (swipeToDismissBoxState.dismissDirection == SwipeToDismissBoxValue.EndToStart) Color.Red.copy(alpha = 0.8f) else Color.Transparent
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color, shape = RoundedCornerShape(20.dp))
                    .padding(end = 24.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    ) {
        // Glassmorphism Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(GlassWhite, shape = RoundedCornerShape(20.dp))
                .border(1.dp, GlassBorder, RoundedCornerShape(20.dp))
                .padding(CommonPaddingDefault)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = city.name,
                        style = Typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        color = Color.White
                    )
                    Text(
                        text = city.country,
                        style = Typography.bodyMedium,
                        color = TextSecondary
                    )
                }
                IconButton(
                    onClick = { onMap(city) },
                    colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White)
                ) {
                    Icon(
                        imageVector = Icons.Default.Map,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemCityPreview(){
    WeatherAppTheme {
        Box(modifier = Modifier.background(Brush.verticalGradient(GradientDeepBlue)).padding(20.dp)) {
            ItemCityView(cityPreview, {}){}
        }
    }
}
