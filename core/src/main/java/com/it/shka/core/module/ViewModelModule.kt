package com.it.shka.core.module



import com.it.shka.feature_main.presentation.DataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule= module {
    viewModel{DataViewModel(get()) }
}