package com.it.shka.feature_bottom_sheet.data.repository

import com.it.shka.core.dao.SearchCacheDao
import com.it.shka.feature_bottom_sheet.data.mapper.Mapper
import com.it.shka.feature_bottom_sheet.domain.repository.LocalDataBottomSheetRepository
import com.it.shka.feature_bottom_sheet.domain.model.SearchCache
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class LocalDataBottomSheetRepositoryImpl(private val database: SearchCacheDao) :
    LocalDataBottomSheetRepository {

    override suspend fun getSearchCache(): Flow<SearchCache>  {
          return withContext(Dispatchers.IO) {
            Mapper().map(database.getSearchCache())
        }
    }

}