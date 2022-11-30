package com.example.models.response.search

@kotlinx.serialization.Serializable
data class SearchResult(
    val videos: List<Video>,
    val count: Int = videos.size
)
