package com.arnedo.weatherapp

import android.app.Application
import com.arnedo.weatherapp.common.di.utilsModule
import com.arnedo.weatherapp.weather.di.remoteDataSourceModule
import com.arnedo.weatherapp.weather.di.weatherModule
import org.koin.core.context.GlobalContext.startKoin

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(weatherModule, utilsModule, remoteDataSourceModule)
        }
    }
}