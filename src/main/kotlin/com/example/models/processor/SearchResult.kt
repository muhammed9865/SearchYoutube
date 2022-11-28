package com.example.models.processor

@kotlinx.serialization.Serializable
data class SearchResult(
    val videos: List<Video>
) {
    fun containsData() = videos.isNotEmpty()
}