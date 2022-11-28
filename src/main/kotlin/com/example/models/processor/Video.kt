package com.example.models.processor

@kotlinx.serialization.Serializable
data class Video(
    val channel: String,
    val duration: String,
    val id: String,
    val long_desc: String?,
    val publish_time: String,
    val thumbnails: List<String?>,
    val title: String,
    val url_suffix: String,
    val views: String,
) {
    fun smallThumbnail() = try {
        thumbnails[0]
    }catch (e: Exception) {
        null
    }
    fun largeThumbnail() = try {
        thumbnails[1]
    }catch (e: Exception) {
        null
    }

    fun hasDescription() = long_desc != null
}