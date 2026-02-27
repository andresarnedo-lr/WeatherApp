package com.arnedo.weatherapp.cities.model

import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.model.CityDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDatabase(private val cityDao : CityDao) {
    suspend fun getAllCities(onResult:(List<City>) -> Unit) = withContext(Dispatchers.IO){
        onResult(cityDao.getAllCities())
    }
}