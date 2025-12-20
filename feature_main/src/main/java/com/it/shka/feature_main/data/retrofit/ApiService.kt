package com.it.shka.feature_main.data.retrofit

import com.it.shka.feature_main.domain.model.Offer
import retrofit2.http.GET

interface ApiService {
    @GET("/offers")
    suspend fun getOffer(): List<Offer>
}