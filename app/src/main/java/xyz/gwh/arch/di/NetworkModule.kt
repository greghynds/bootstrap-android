package xyz.gwh.arch.di

import com.allsouls.newsapp.BuildConfig
import xyz.gwh.arch.data.ClientConfig
import org.koin.dsl.module

val networkModule = module {
    single { ClientConfig(BuildConfig.HOST, get(), loggingEnabled = BuildConfig.DEBUG) }
}