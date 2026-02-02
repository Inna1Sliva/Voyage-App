package com.it.shka.feature_main.domain.useCase

import com.it.shka.feature_main.domain.model.SearchCache
import com.it.shka.feature_main.domain.repository.LocalDataSourceRepository
import com.it.shka.feature_main.domain.useCase.LocalDataSourceUseCase
import kotlinx.coroutines.flow.Flow

class LocalDataSourceUseCaseImpl(private val localDataSourceRepository: LocalDataSourceRepository):
    LocalDataSourceUseCase {
    override suspend fun insertSearchCache(searchCache: SearchCache) {
       return localDataSourceRepository.insertSearchCache(searchCache = searchCache)
    }

    override suspend fun updateSearchCache(searchCache: SearchCache) {
        return localDataSourceRepository.updateSearchCache(searchCache = searchCache)
    }

    override suspend fun deleteSearchCache(searchCache: SearchCache) {
        return localDataSourceRepository.deleteSearchCache(searchCache = searchCache)
    }

    override suspend fun getSearchCache(): Flow<SearchCache> {
       return localDataSourceRepository.getSearchCache()
    }

}