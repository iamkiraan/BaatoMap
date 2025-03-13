package com.example.baatomap.DataClasses

data class SearchResult(
    val address: String,
    val name: String,
    val placeId: Int,
    val score: Double,
    val type: String,
    val latitude: Double,
    val longitude: Double
)