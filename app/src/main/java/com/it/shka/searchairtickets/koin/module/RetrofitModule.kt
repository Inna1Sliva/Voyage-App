package com.it.shka.searchairtickets.koin.module

import com.it.shka.feature_main.data.retrofit.ApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val RetrofitModule = module{
single<Retrofit> {
    Retrofit.Builder()
    .baseUrl("http://192.168.42.242:3700")
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()
}
    single {providesApiService(get())  }
}


fun providesApiService(retrofit: Retrofit):ApiService{
    return retrofit.create(ApiService::class.java)
}