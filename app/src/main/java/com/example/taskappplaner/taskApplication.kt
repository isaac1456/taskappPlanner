package com.example.taskappplaner

import android.app.Application
import com.example.taskappplaner.dependencies.moduleTaksInject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class taskApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // declare used Android context
            androidContext(this@taskApplication)
            // declare modules
            modules(moduleTaksInject)
        }
    }

}