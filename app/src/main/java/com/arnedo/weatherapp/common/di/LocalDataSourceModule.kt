package com.arnedo.weatherapp.common.di

import android.app.Application
import androidx.room.Room
import com.arnedo.weatherapp.common.model.AppDatabase
import com.arnedo.weatherapp.common.model.CityDao
import com.arnedo.weatherapp.common.utils.Constants
import org.koin.dsl.module

fun provideDatabase(application: Application) : AppDatabase {
    return Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        Constants.DB_NAME)
        .build()
}
fun provideCityDao(database: AppDatabase) : CityDao = database.cityDao()

val localDataSourceModule = module {
    single{provideCityDao(get())}
    single{provideDatabase(get())}

}