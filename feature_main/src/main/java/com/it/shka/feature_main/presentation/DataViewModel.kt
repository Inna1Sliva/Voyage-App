package com.it.shka.feature_main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_main.data.ImplDataRepository
import com.it.shka.feature_main.model.Offer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DataViewModel(private val repository: ImplDataRepository): ViewModel() {
    private val _searchState = MutableStateFlow(SearchState())
    val whereFromState: StateFlow<SearchState> get() = _searchState
    private val _offerState = MutableStateFlow<List<Offer>>(emptyList())
    val offerState: StateFlow<List<Offer>> get() = _offerState
init {
    getOffer()
}

    fun setSearchWhereFrom(textWhere: String){
        viewModelScope.launch {
           _searchState.update { it.copy(whereFrom = textWhere) }
        }

    }
    fun setSearchWhere(where: String ){
        viewModelScope.launch {
            _searchState.update { it.copy(where = where) }
        }

    }
    fun getOffer(){
        viewModelScope.launch {
            try {
                _offerState.value = repository.getOffer()
            } catch (e: Exception){
                println(e)

            }
        }

    }
}