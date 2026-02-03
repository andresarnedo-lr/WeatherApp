package com.arnedo.weatherapp.weather.di

import com.arnedo.weatherapp.weather.model.RemoteDatabase
import com.arnedo.weatherapp.weather.viewmodel.WeatherViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val weatherModule = module {
    single{ RemoteDatabase(null,get()) }
    viewModel{ WeatherViewModel(get()) }
}