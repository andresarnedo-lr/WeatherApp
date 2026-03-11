package com.arnedo.weatherapp

import com.arnedo.weatherapp.common.utils.FormatUtilsTest
import com.arnedo.weatherapp.weather.domain.DataSourceTest
import com.arnedo.weatherapp.weather.model.RemoteDatabaseTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    FormatUtilsTest::class,
    RemoteDatabaseTest::class,
    DataSourceTest::class
)
class AllTests {
}