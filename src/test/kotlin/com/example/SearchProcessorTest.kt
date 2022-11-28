package com.example

import com.example.core.processor.SearchProcessor
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class SearchProcessorTest {
    @Test
    fun test_search_generates_result() {
        val processor = SearchProcessor()
        processor.search("bigsam")
        val path = "E:\\KTOR Projects\\SearchYoutube\\src\\main\\resources"
        val file = File(path)
        assertEquals(true, file.exists())
    }

    @Test
    fun test_search_return_result() {
        val processor = SearchProcessor()
        val result = processor.search("bigsam")
        assert(result.videos.isNotEmpty())
    }
}