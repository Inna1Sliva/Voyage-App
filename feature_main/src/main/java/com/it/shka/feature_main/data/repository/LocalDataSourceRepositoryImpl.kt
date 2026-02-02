package com.it.shka.feature_main.data.repository

import com.it.shka.core.dao.SearchCacheDao
import com.it.shka.feature_main.data.mapper.Mapper
import com.it.shka.feature_main.domain.model.SearchCache
import com.it.shka.feature_main.domain.repository.LocalDataSourceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class LocalDataSourceRepositoryImpl(private val localData: SearchCacheDao,
                                    private val mapper: Mapper): LocalDataSourceRepository {
    override suspend fun insertSearchCache(searchCache: SearchCache) {
      withContext(Dispatchers.IO){
          localData.insertSearchCache(mapper.toData(searchCache = searchCache))}
    }

    override suspend fun updateSearchCache(searchCache: SearchCache) {
        withContext(Dispatchers.IO){
            localData.updateSearchCache(searchCacheEntity = mapper.toData(searchCache = searchCache))
        }
    }

    override suspend fun deleteSearchCache(searchCache: SearchCache) {
        withContext(Dispatchers.IO){
            localData.deleteSearchCache(mapper.toData(searchCache = searchCache))}
    }

    override suspend fun getSearchCache():Flow<SearchCache> {
        return withContext(Dispatchers.IO) { mapper.map(localData.getSearchCache()) }
    }
}