package com.arnedo.weatherapp.cities.di

import com.arnedo.weatherapp.cities.model.LocalDatabase
import com.arnedo.weatherapp.cities.viewmodel.CitiesViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val citiesModule = module {
    single { LocalDatabase(get()) }
    viewModel { CitiesViewModel(get(), get()) }
}