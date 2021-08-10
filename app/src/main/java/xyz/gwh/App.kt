package xyz.gwh

import android.app.Application
import org.koin.core.context.startKoin
import xyz.gwh.arch.di.asyncModule
import xyz.gwh.arch.di.networkModule
import xyz.gwh.arch.di.serializationModule

class App : Application() {

    private val modules = listOf(
        asyncModule,
        serializationModule,
        networkModule,
    )

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(modules)
        }
    }
}