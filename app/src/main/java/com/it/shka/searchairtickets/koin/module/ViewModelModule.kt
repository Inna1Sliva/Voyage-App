package com.it.shka.searchairtickets.koin.module



import com.it.shka.feature_bottom_sheet.domain.usecase.LocalDataBottomSheetUseCase
import com.it.shka.feature_bottom_sheet.presentation.BottomSheetViewModel
import com.it.shka.feature_main.domain.useCase.LocalDataSourceUseCase
import com.it.shka.feature_main.domain.repository.RemoteDataSourceRepository
import com.it.shka.feature_main.presentation.model.DataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule= module {
    viewModel{DataViewModel(get<RemoteDataSourceRepository>(),get<LocalDataSourceUseCase>()) }
    viewModel{BottomSheetViewModel(get<LocalDataBottomSheetUseCase>())}
}