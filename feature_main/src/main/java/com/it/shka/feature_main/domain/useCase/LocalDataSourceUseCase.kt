package com.it.shka.feature_main.domain.useCase

import com.it.shka.feature_main.domain.model.SearchCache
import kotlinx.coroutines.flow.Flow

interface LocalDataSourceUseCase {
    suspend fun insertSearchCache(searchCache: SearchCache)
    suspend fun updateSearchCache(searchCache: SearchCache)
    suspend fun deleteSearchCache(searchCache: SearchCache)
    suspend fun getSearchCache(): Flow<SearchCache>
}