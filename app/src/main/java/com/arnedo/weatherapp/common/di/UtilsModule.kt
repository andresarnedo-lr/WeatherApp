package com.arnedo.weatherapp.common.di

import com.arnedo.weatherapp.common.utils.FormatUtils
import com.arnedo.weatherapp.common.utils.IntentUtils
import com.arnedo.weatherapp.common.utils.NetworkUtils
import org.koin.dsl.module

val utilsModule = module {
    single{ FormatUtils() }
    single{ NetworkUtils(get()) }
    single { IntentUtils(get()) }
}