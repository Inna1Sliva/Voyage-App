package com.it.shka.searchairtickets.koin



import com.it.shka.feature_main.data.ImplDataRepository
import com.it.shka.feature_main.domain.DataRepository
import com.it.shka.feature_main.presentation.DataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule= module {
    single<DataRepository>{ ImplDataRepository(get()) }
    viewModel{DataViewModel(get()) }
}