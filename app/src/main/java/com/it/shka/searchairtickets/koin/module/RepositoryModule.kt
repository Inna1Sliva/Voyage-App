package com.it.shka.searchairtickets.koin.module

import com.it.shka.core.dao.SearchCacheDao
import com.it.shka.feature_bottom_sheet.data.repository.LocalDataBottomSheetRepositoryImpl
import com.it.shka.feature_bottom_sheet.domain.repository.LocalDataBottomSheetRepository
import com.it.shka.feature_main.data.mapper.Mapper
import com.it.shka.feature_main.data.repository.LocalDataSourceRepositoryImpl
import com.it.shka.feature_main.data.repository.RemoteDataSourceRepositoryImpl
import com.it.shka.feature_main.domain.repository.LocalDataSourceRepository
import com.it.shka.feature_main.domain.repository.RemoteDataSourceRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single<LocalDataBottomSheetRepository> { LocalDataBottomSheetRepositoryImpl(get<SearchCacheDao>()) }
    single<RemoteDataSourceRepository>{ RemoteDataSourceRepositoryImpl(get()) }
    single<LocalDataSourceRepository>{ LocalDataSourceRepositoryImpl(get<SearchCacheDao>(), get()) }
    single { Mapper() }

}