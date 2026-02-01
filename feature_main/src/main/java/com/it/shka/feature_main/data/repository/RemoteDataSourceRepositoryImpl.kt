package com.it.shka.feature_main.data.repository

import com.it.shka.feature_main.data.network.ApiService
import com.it.shka.feature_main.domain.repository.RemoteDataSourceRepository
import com.it.shka.feature_main.domain.model.Offer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class RemoteDataSourceRepositoryImpl(private val apiService: ApiService): RemoteDataSourceRepository {
    override suspend fun getOffer(): List<Offer> {
       return withContext(Dispatchers.IO) {
           delay(3000)
           apiService.getOffer() }
    }
}