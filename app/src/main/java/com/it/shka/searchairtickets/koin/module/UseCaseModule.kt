package com.it.shka.searchairtickets.koin.module

import com.it.shka.feature_bottom_sheet.domain.repository.LocalDataBottomSheetRepository
import com.it.shka.feature_bottom_sheet.domain.usecase.LocalDataBottomSheetUseCase
import com.it.shka.feature_bottom_sheet.domain.usecase.LocalDataBottomSheetUseCaseImpl
import com.it.shka.feature_main.domain.repository.LocalDataSourceRepository
import com.it.shka.feature_main.domain.useCase.LocalDataSourceUseCase
import com.it.shka.feature_main.domain.useCase.LocalDataSourceUseCaseImpl
import org.koin.dsl.module

val UseCase = module {
    single<LocalDataSourceUseCase>{ LocalDataSourceUseCaseImpl(get<LocalDataSourceRepository>()) }
    single<LocalDataBottomSheetUseCase> { LocalDataBottomSheetUseCaseImpl(get<LocalDataBottomSheetRepository>()) }
}