package com.it.shka.data.repository

import com.it.shka.data.retrofit.ApiService
import com.it.shka.domain.DataRepository

class ImplDataRepository(private val apiService: ApiService):DataRepository {

    override suspend fun getData() {
        TODO("Not yet implemented")
    }
}