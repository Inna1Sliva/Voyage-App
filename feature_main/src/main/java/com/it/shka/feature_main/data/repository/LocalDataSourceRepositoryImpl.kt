package com.it.shka.feature_main.data.repository

import com.it.shka.core_database.dao.SearchCacheDao
import com.it.shka.feature_main.data.mapper.Mapper
import com.it.shka.feature_main.domain.model.SearchCache
import com.it.shka.feature_main.domain.repository.LocalDataSourceRepository
import kotlinx.coroutines.flow.Flow

class LocalDataSourceRepositoryImpl(private val localData: SearchCacheDao,
    private val mapper: Mapper): LocalDataSourceRepository {
    override suspend fun insertSearchCache(searchCache: SearchCache) {
       localData.insertSearchCache(mapper.toData(searchCache = searchCache))
    }

    override suspend fun updateSearchCache(id: Int) {
        localData.updateSearchCache(id = id)
    }

    override suspend fun deleteSearchCache(searchCache: SearchCache) {
        localData.deleteSearchCache(mapper.toData(searchCache = searchCache))
    }

    override suspend fun getSearchCache(): Flow<SearchCache> {
       return mapper.map(localData.getSearchCache())
    }
}