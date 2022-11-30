package com.example.models.response.fetch

@kotlinx.serialization.Serializable
data class PlayableVideo(
    val id: String,
    val title: String,
    val description: String,
    val url: String,
)
