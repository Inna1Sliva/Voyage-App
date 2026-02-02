package com.it.shka.feature_main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_main.domain.repository.RemoteDataSourceRepository
import com.it.shka.feature_main.domain.model.Offer
import com.it.shka.feature_main.domain.useCase.LocalDataSourceUseCase
import com.it.shka.feature_main.presentation.extension.toDomain
import com.it.shka.feature_main.presentation.extension.toSearchCacheUi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DataViewModel(private val dataRepository: RemoteDataSourceRepository,
     private val local: LocalDataSourceUseCase
): ViewModel() {
    private val _searchCacheUiState = MutableStateFlow(SearchCacheUi())
    val searchCacheUiState: StateFlow<SearchCacheUi> get() = _searchCacheUiState
    private val _setSearchCacheUiState = MutableStateFlow(SearchCacheUiState())
    private val setSearchCacheUiState: StateFlow<SearchCacheUiState> get() = _setSearchCacheUiState
    private val _offerState = MutableStateFlow<List<Offer>>(emptyList())
    val offerState: StateFlow<List<Offer>> get() = _offerState
init {
    getOffer()
    getSearchCache()
}

    fun setSearchWhereFrom(textWhere: String){
        viewModelScope.launch {
           _setSearchCacheUiState.update { it.copy(cacheUi = SearchCacheUi(cache = textWhere) ) }
            try {
                local.insertSearchCache(setSearchCacheUiState.value.cacheUi!!.toDomain() )
            }catch (e:Exception){
                println(e)
            }
        }

    }
    fun getSearchCache(){
        viewModelScope.launch {
            try {
                local.getSearchCache().collect { searchCache ->
                    _searchCacheUiState.update { it.copy(id = searchCache.id, cache = searchCache.cache) }
                }
            } catch (e: Exception){
                println(e)
            }
        }
    }

    fun getOffer(){
        viewModelScope.launch {

            try {
                _offerState.value = dataRepository.getOffer()
            } catch (e: Exception){
                println(e)

            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}
