package com.arnedo.weatherapp.common.utils

import com.arnedo.weatherapp.common.entities.City
import com.arnedo.weatherapp.common.entities.WeatherResponse
import com.arnedo.weatherapp.common.model.weatherResponseTest
import org.junit.Assert.*
import org.junit.Test

class FormatUtilsTest {
    @Test
    fun responseToWeatherCitySuccess() {
        val utils = FormatUtils()
        val response = weatherResponseTest
        val result = utils.responseToWeatherCity(response)

        assertNotNull(result)
    }

    @Test
    fun responseToWeatherCityEmpty() {
        val utils = FormatUtils()
        val response = WeatherResponse()
        val result = utils.responseToWeatherCity(response)

        assert(result!!.name.isEmpty() && result.country.isEmpty())
    }


    @Test
    fun responseToWeatherCityFails() {
        val utils = FormatUtils()
        val response = weatherResponseTest.copy(location = City(lat = 200.0))
        val result = utils.responseToWeatherCity(response)

        assertNull(result)
    }
}
