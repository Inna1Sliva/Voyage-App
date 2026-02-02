package com.it.shka.feature_bottom_sheet.domain.usecase

import com.it.shka.feature_bottom_sheet.domain.model.SearchCache
import kotlinx.coroutines.flow.Flow

interface LocalDataBottomSheetUseCase {
    suspend fun getSearchCache(): Flow<SearchCache>
}