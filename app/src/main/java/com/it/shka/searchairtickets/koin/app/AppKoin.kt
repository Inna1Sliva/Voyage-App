package com.it.shka.searchairtickets.koin.app

import android.app.Application
import com.it.shka.searchairtickets.koin.module.LocalDataModule
import com.it.shka.searchairtickets.koin.module.RepositoryModule
import com.it.shka.searchairtickets.koin.module.RetrofitModule
import com.it.shka.searchairtickets.koin.module.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AppKoin: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@AppKoin)
            modules(
                listOf(
                    RetrofitModule,
                    RepositoryModule,
                    ViewModelModule,
                    LocalDataModule
                )
            )
        }
    }
}