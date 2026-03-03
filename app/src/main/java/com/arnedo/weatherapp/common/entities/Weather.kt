package com.arnedo.weatherapp.common.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arnedo.weatherapp.common.utils.Constants

@Entity(tableName = Constants.E_WEATHER)
data class Weather(
    @PrimaryKey(autoGenerate = true) var id : Long = 0,
    var temp_c: Float = 0f,
    var description: String = "",
    var wind_kph: Float = 0f,
    var iconHttps: String = "",
    var cityId : Long = 0
)
