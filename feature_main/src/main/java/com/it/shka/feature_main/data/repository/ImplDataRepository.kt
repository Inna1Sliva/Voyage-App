package com.it.shka.feature_main.data.repository

import com.it.shka.feature_main.data.retrofit.ApiService
import com.it.shka.feature_main.domain.repository.DataRepository
import com.it.shka.feature_main.domain.model.Offer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ImplDataRepository(private val apiService: ApiService): DataRepository {
    override suspend fun getOffer(): List<Offer> {
       return withContext(Dispatchers.IO) {
           delay(3000)
           apiService.getOffer() }
    }
}