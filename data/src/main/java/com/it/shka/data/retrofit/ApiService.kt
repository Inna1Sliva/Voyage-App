package com.it.shka.data.retrofit

import com.it.shka.data.model.Offer
import retrofit2.http.GET

interface ApiService {
    @GET("ad9a46ba-276c-4a81-88a6-c068e51cce3a")
    fun getData(): Offer
}