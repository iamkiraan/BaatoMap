package com.example.baatomap.DataClasses

data class SearchDataClass(
    val `data`: List<SearchResult>,
    val message: String,
    val status: Int,
    val timestamp: String
)