package com.it.shka.searchairtickets.koin.module




import androidx.room.Room
import com.it.shka.core.AppDatabase
import com.it.shka.core.dao.SearchCacheDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val LocalDataModule = module {
    single<AppDatabase>{ Room.databaseBuilder(
        androidContext(),
        AppDatabase::class.java,
        "local_database"
    ).build()
    }
    single<SearchCacheDao>{ get<AppDatabase>().searchCacheDao() }
}