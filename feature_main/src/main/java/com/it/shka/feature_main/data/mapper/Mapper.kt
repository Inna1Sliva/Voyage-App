package com.it.shka.feature_main.data.mapper

import com.it.shka.core_database.entity.SearchCacheEntity
import com.it.shka.feature_main.domain.model.SearchCache
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Mapper {

    fun toData(searchCache: SearchCache): SearchCacheEntity {
        return SearchCacheEntity(
            id = searchCache.id,
            cache = searchCache.cache
        )
    }
    fun map(flow: Flow<SearchCacheEntity>): Flow<SearchCache> {
    return flow.map { entity ->
        SearchCache(
            id = entity.id,
            cache = entity.cache
        )
    }

    }
}