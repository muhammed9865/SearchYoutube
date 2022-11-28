package com.example.models.response

@kotlinx.serialization.Serializable
data class Video(
    val id: String,
    val title: String,
    val channel: String,
    val duration: String,
    val long_desc: String?,
    val small_thumbnail: String?,
    val large_thumbnail: String?,
    val publish_time: String,
)
