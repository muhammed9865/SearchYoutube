package com.example.core.processor.fetch

import com.example.models.response.fetch.PlayableVideo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

sealed class FetchResultExtractor {

    companion object {
        fun extract(process: Process) : PlayableVideo? {
            val reader = process.inputStream.bufferedReader()
            var output = reader.readText()

            return try {
                Json.decodeFromString<PlayableVideo>(output)
            }catch (e: Exception) {
                e.printStackTrace()
                null
            }finally {
                reader.close()
            }
        }
    }
}