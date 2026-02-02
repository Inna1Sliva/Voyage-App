package com.it.shka.core

import androidx.room.Database
import androidx.room.RoomDatabase
import com.it.shka.core.dao.SearchCacheDao
import com.it.shka.core.entity.SearchCacheEntity

@Database(
    entities = [SearchCacheEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun searchCacheDao(): SearchCacheDao
}