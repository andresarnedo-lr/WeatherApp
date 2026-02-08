package com.arnedo.weatherapp.common.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.entities.Weather
import com.arnedo.weatherapp.common.utils.Constants

@Database(entities = [City::class, Weather::class], version = Constants.DB_INIT_VERSION)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cityDao() : CityDao
}