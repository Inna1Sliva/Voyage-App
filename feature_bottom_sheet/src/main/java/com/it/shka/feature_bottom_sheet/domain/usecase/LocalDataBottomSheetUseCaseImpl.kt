package com.it.shka.feature_bottom_sheet.domain.usecase

import com.it.shka.feature_bottom_sheet.domain.model.SearchCache
import com.it.shka.feature_bottom_sheet.domain.repository.LocalDataBottomSheetRepository
import kotlinx.coroutines.flow.Flow

class LocalDataBottomSheetUseCaseImpl(private val repository: LocalDataBottomSheetRepository):
LocalDataBottomSheetUseCase{
    override suspend fun getSearchCache(): Flow<SearchCache> {
        return repository.getSearchCache()
    }
}