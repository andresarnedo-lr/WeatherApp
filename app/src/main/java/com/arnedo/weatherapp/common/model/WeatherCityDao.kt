package com.arnedo.weatherapp.common.model

import androidx.room.Dao
import androidx.room.Transaction
import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.entities.Weather

@Dao
interface WeatherCityDao : CityDao, WeatherDao {
    @Transaction
    suspend fun addCityAndWeather(city: City, weather: Weather) : Long {
        val dbCity = getCityByLatLon(city.lat, city.lon)
        if(dbCity == null){
            return addWeather(weather.copy(cityId = addCity(city)))
        } else {
            getWeatherByCityId(dbCity.id)?.let { dbWeather ->
                return updateWeather(weather.copy(id = dbWeather.id, cityId = dbWeather.cityId)).toLong()
            }
        }
        return 0
    }
}