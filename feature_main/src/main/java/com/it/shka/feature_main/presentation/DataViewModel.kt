package com.it.shka.feature_main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_main.data.ImplDataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DataViewModel(private val repository: ImplDataRepository): ViewModel() {
    private val _searchState = MutableStateFlow(SearchState())
    val whereFromState: StateFlow<SearchState> get() = _searchState


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
}