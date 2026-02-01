package com.it.shka.core_database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.it.shka.core_database.entity.SearchCacheEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchCacheDao {
    @Insert
    suspend fun insertSearchCache(searchCacheEntity: SearchCacheEntity)
    @Update
    suspend fun updateSearchCache(id: Int)
    @Delete
    suspend fun deleteSearchCache(searchCacheEntity: SearchCacheEntity)
    @Query("SELECT * FROM cache")
    suspend fun getSearchCache(): Flow<SearchCacheEntity>
}