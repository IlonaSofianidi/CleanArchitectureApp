package com.test.testassignment

import android.app.Application
import com.test.testassignment.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(viewModels + useCaseModules + repositoryModules + dataSourceModules + networking)
        }
    }
}