package xyz.gwh.arch.di

import com.fasterxml.jackson.databind.ObjectMapper
import org.koin.dsl.module

val serializationModule = module {
    val mapper = ObjectMapper()

    single { mapper }
}