package xyz.gwh

import android.app.Application
import xyz.gwh.arch.di.asyncModule
import xyz.gwh.arch.di.networkModule
import xyz.gwh.arch.di.serializationModule
import xyz.gwh.feed.di.feedModule
import org.koin.core.context.startKoin

class App : Application() {

    private val modules = listOf(
        asyncModule,
        serializationModule,
        networkModule,
        feedModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(modules)
        }
    }
}