package com.it.shka.searchairtickets.koin


import com.it.shka.data.repository.ImplDataRepository
import com.it.shka.domain.DataRepository
import com.it.shka.searchairtickets.viewmodel.DataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule= module {
    single<DataRepository>{ ImplDataRepository(get())  }
    viewModel{DataViewModel(get()) }
}