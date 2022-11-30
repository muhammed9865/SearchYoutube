package com.example.core.mapper

import com.example.models.processor.SearchResult
import com.example.models.processor.Video

fun SearchResult.mapToResponse() = com.example.models.response.search.SearchResult(
    videos = videos.map { it.mapToResponse() }
)

fun Video.mapToResponse() : com.example.models.response.search.Video {
    return com.example.models.response.search.Video(
        id = id,
        title = title,
        channel = channel,
        duration = duration,
        long_desc = long_desc,
        small_thumbnail = smallThumbnail(),
        large_thumbnail = largeThumbnail(),
        publish_time = publish_time
    )
}