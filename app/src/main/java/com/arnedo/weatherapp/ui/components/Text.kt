package com.arnedo.weatherapp.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.arnedo.weatherapp.ui.theme.Typography

@Composable

fun MyTextTitle(titleRes: Int) {
        Text(
            stringResource(titleRes),
            textAlign = TextAlign.Center,
            style = Typography.headlineMedium

        )
}