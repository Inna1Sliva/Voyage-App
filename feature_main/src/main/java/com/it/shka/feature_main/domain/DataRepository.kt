package com.it.shka.feature_main.domain

import com.it.shka.feature_main.domain.model.Offer

interface DataRepository {
    suspend fun getOffer(): List<Offer>
}