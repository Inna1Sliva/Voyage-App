package com.it.shka.searchairtickets.koin.module

import com.it.shka.feature_main.domain.repository.LocalDataSourceUseCase
import com.it.shka.feature_main.domain.useCase.LocalDataSourceUseCaseImpl
import org.koin.dsl.module

val UseCase = module {
    single<LocalDataSourceUseCase>{ LocalDataSourceUseCaseImpl(get()) }
}