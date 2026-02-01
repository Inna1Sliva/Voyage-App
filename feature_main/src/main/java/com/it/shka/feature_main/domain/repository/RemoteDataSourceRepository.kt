package com.it.shka.feature_main.domain.repository

import com.it.shka.feature_main.domain.model.Offer

interface RemoteDataSourceRepository {
    suspend fun getOffer(): List<Offer>
}