package com.it.shka.feature_main.domain.repository

import com.it.shka.feature_main.domain.model.SearchCache
import kotlinx.coroutines.flow.Flow

interface LocalDataSourceUseCase {
    suspend fun insertSearchCache(searchCache: SearchCache)
    suspend fun updateSearchCache(id: Int)
    suspend fun deleteSearchCache(searchCache: SearchCache)
    suspend fun getSearchCache(): Flow<SearchCache>
}