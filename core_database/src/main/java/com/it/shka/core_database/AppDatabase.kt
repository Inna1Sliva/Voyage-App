package com.it.shka.core_database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.it.shka.core_database.dao.SearchCacheDao
import com.it.shka.core_database.entity.SearchCacheEntity

@Database(
    entities = [SearchCacheEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun searchCacheDao(): SearchCacheDao
}