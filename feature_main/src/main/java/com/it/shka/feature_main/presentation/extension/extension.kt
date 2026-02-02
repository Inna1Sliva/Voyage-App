package com.it.shka.feature_main.presentation.extension

import com.it.shka.feature_main.domain.model.SearchCache
import com.it.shka.feature_main.presentation.SearchCacheUi

fun SearchCacheUi.toDomain(): SearchCache {
    return SearchCache(
        id = this.id,
        cache = this.cache
    )
}
fun SearchCache.toSearchCacheUi(): SearchCacheUi{
    return SearchCacheUi(
        id = this.id,
        cache = this.cache
    )
}