package com.it.shka.feature_main.domain.repository

import com.it.shka.feature_main.domain.model.Offer

interface DataRepository {
    suspend fun getOffer(): List<Offer>
}