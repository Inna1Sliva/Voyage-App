package com.it.shka.searchairtickets.koin

import com.it.shka.data.repository.ImplDataRepository
import com.it.shka.data.retrofit.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val RetrofitModule = module{
single { ImplDataRepository(providesApiService(providesRetrofit())) }
}
fun providesRetrofit():Retrofit{
    return Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
fun providesApiService(retrofit: Retrofit):ApiService{
    return retrofit.create(ApiService::class.java)
}