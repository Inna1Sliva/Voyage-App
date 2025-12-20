package com.it.shka.feature_main.domain.model

data class Offer(
    val id: Int,
    val price: Price,
    val image: String,
    val title: String,
    val town: String
)