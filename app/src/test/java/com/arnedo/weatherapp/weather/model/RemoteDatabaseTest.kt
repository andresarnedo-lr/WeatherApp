package com.arnedo.weatherapp.weather.model

import com.arnedo.weatherapp.common.entities.WeatherResponse
import com.arnedo.weatherapp.common.model.weatherResponseTest
import com.arnedo.weatherapp.common.utils.Constants
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class RemoteDatabaseTest {
    private lateinit var mockService: WeatherService
    private lateinit var rdb: RemoteDatabase

    @Before
    fun setUp() {
        mockService = mock<WeatherService>()
        rdb = RemoteDatabase(mockService)
    }

    @Test
    fun searchWeatherByName() = runTest {
        whenever(mockService.searchWeatherByName(Constants.API_KEY, "Madrid", Constants.LANG_ES))
            .thenReturn(weatherResponseTest)
//        val rdb = RemoteDatabase(mockService)
        var result = WeatherResponse()

        rdb.searchWeatherByName("Madrid") { result = it }

        assertNotNull(result)
        verify(mockService).searchWeatherByName(Constants.API_KEY, "Madrid", Constants.LANG_ES)
    }

    @Test
    fun getWeatherByCoordinates() = runTest {
        val emptyCoordiantes = "0.0, 0.0"
        whenever(mockService.getWeatherByCoordinates(Constants.API_KEY, emptyCoordiantes , Constants.LANG_ES))
            .thenReturn(null)
//        val rdb = RemoteDatabase(mockService)
        var result: WeatherResponse? = WeatherResponse()

        rdb.getWeatherByCoordinates(emptyCoordiantes) { result = it }

        assertNull(result)
        verify(mockService).getWeatherByCoordinates(Constants.API_KEY, emptyCoordiantes, Constants.LANG_ES)
    }

}