package com.example.core.processor

import com.example.models.processor.SearchResult
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

class SearchResultExtractor {
    fun extract(): SearchResult? {
        // Opening the result file "result.json"
        val resultFile = File(SearchConstants.resultFilePath)

        if (!resultFile.exists()) {
            println("Result.json is not found")
            return null
        }

        // Reading the file content as string
        val lines = resultFile.readText()

        // If couldn't decode lines to model, return null
        return try {
            Json.decodeFromString<SearchResult>(lines).also {
                // deleting result after getting result
                resultFile.delete()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }

    }
}