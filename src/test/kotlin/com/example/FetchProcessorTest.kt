package com.example

import com.example.core.processor.fetch.FetchProcessor
import com.example.models.request.FetchRequest
import org.junit.Test
import kotlin.test.assertEquals

class FetchProcessorTest {

    @Test
    fun test_fetch_with_valid_id_returns_result() {
        // Given
        val processor = FetchProcessor()
        val videoId = "99pA0OFcenM"
        val fetchRequest = FetchRequest(videoId)

        // When
        val result = processor.fetch(fetchRequest)

        // Then
        assertEquals(result.id, videoId)

    }
}