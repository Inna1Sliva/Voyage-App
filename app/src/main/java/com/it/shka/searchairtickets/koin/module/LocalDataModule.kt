package com.it.shka.searchairtickets.koin.module


import androidx.room.Room
import com.it.shka.core_database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val LocalDataModule  = module{
single{
    Room.databaseBuilder(
        androidContext(),
        AppDatabase::class.java,
        "local_database"
    ).build()
}
    single { get<AppDatabase>().searchCacheDao() }
}