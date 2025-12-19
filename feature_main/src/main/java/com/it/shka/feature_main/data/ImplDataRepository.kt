package com.it.shka.feature_main.data

import com.it.shka.feature_main.data.retrofit.ApiService
import com.it.shka.feature_main.domain.DataRepository

class ImplDataRepository(private val apiService: ApiService): DataRepository {

    override suspend fun getData() {
        TODO("Not yet implemented")
    }
}