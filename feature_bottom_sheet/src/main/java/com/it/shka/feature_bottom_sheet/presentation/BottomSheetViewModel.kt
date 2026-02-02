package com.it.shka.feature_bottom_sheet.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_bottom_sheet.domain.usecase.LocalDataBottomSheetUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BottomSheetViewModel(private val local: LocalDataBottomSheetUseCase) : ViewModel() {
    private val _searchCacheUi = MutableStateFlow(SearchCacheUi())
    val searchCacheUi: StateFlow<SearchCacheUi> get() = _searchCacheUi

    init {
        getSearchCache()
    }

    fun getSearchCache() {
        viewModelScope.launch {
            _searchCacheUi.update { it.copy(id = null, cache = null) }
            try {
                local.getSearchCache().collect { cache ->
                    _searchCacheUi.update { it.copy(id = cache.id, cache = cache.cache) }
                }
            } catch (e: Exception) {
                println(e)
            }

        }
    }

    override fun onCleared() {
        super.onCleared()

    }
}
