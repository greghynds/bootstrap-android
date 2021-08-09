package xyz.gwh.arch.di

import xyz.gwh.arch.presentation.AndroidDispatchers
import xyz.gwh.arch.presentation.Dispatchers
import org.koin.dsl.module

val asyncModule = module {
    single<Dispatchers> { AndroidDispatchers() }
}