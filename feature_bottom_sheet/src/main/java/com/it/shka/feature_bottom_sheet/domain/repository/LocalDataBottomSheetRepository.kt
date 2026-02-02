package com.it.shka.feature_bottom_sheet.domain.repository

import com.it.shka.feature_bottom_sheet.domain.model.SearchCache
import kotlinx.coroutines.flow.Flow

interface LocalDataBottomSheetRepository {
    suspend fun getSearchCache(): Flow<SearchCache>
}