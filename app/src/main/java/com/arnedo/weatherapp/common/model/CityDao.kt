package com.arnedo.weatherapp.common.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.utils.Constants
import kotlinx.coroutines.flow.Flow


@Dao
interface CityDao {
    @Insert
    suspend fun addCity(city: City) : Long
    @Update
    suspend fun updateCity(city: City) : Int
    @Delete
    suspend fun deleteCity(city: City) : Int
    @Query("SELECT * FROM ${Constants.E_CITY}" )
    suspend fun getAllCities() : List<City>

    @Query("SELECT * FROM ${Constants.E_CITY}")
    fun getAllCitiesRealtime() : Flow<List<City>>

    @Query("SELECT * FROM ${Constants.E_CITY}" +
            " WHERE ${Constants.P_LAT} = :lat AND ${Constants.P_LON} = :lon " +
            "LIMIT 1")
    suspend fun getCityByLatLon(lat: Double, lon: Double) : City?
}