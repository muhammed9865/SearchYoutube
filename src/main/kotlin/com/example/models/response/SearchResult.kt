package com.example.models.response

@kotlinx.serialization.Serializable
data class SearchResult(
    val videos: List<Video>,
    val count: Int = videos.size
)
