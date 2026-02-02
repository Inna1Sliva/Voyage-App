package com.it.shka.core.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.it.shka.core.entity.SearchCacheEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchCacheDao{
    @Insert
    suspend fun insertSearchCache(searchCacheEntity: SearchCacheEntity)
    @Update
    suspend fun updateSearchCache(searchCacheEntity: SearchCacheEntity)
    @Delete
    suspend fun deleteSearchCache(searchCacheEntity: SearchCacheEntity)
    @Query("SELECT * FROM cache")
    fun getSearchCache(): Flow<SearchCacheEntity>

}