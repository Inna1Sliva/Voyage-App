package com.it.shka.feature_bottom_sheet.domain

import kotlinx.coroutines.flow.Flow

interface LocalDataBottomSheetRepository {
    suspend fun getSearchCache(): Flow<SearchCache>
}