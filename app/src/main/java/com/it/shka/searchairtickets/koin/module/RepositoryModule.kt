package com.it.shka.searchairtickets.koin.module

import com.it.shka.feature_main.data.repository.ImplDataRepository
import com.it.shka.feature_main.domain.DataRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single<DataRepository>{ ImplDataRepository(get()) }

}