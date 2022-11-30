package com.example

import com.example.core.processor.CommandConstants
import com.example.core.processor.search.SearchProcessor
import com.example.models.request.SearchRequest
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class SearchProcessorTest {
    @Test
    fun test_search_generates_result() {
        // Given
        val processor = SearchProcessor()
        val searchRequest = SearchRequest("Bigsam", 10)

        // When
        processor.search(searchRequest)
        val path = CommandConstants.resultFilePath
        val file = File(path)

        // Then
        assertEquals(true, file.exists())
    }

    @Test
    fun test_search_return_result() {
        val processor = SearchProcessor()
        val searchRequest = SearchRequest("Bigsam", null)
        val result = processor.search(searchRequest)
        assert(result.videos.isNotEmpty())
    }
}