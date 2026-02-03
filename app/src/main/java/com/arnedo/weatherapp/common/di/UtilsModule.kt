package com.arnedo.weatherapp.common.di

import com.arnedo.weatherapp.common.utils.FormatUtils
import org.koin.dsl.module

val utilsModule = module {
    single{ FormatUtils() }
}