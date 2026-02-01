package com.it.shka.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cache")
data class SearchCacheEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val cache:String
)
