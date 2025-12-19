package com.it.shka.feature_main.data

import com.it.shka.feature_main.data.retrofit.ApiService
import com.it.shka.feature_main.domain.DataRepository
import com.it.shka.feature_main.model.Offer
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class ImplDataRepository(private val apiService: ApiService): DataRepository {
    override suspend fun getOffer(): List<Offer> {
       return withContext(IO){ apiService.getOffer()}
    }
}