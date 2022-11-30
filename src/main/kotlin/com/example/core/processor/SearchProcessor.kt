package com.example.core.processor

import com.example.core.mapper.mapToResponse
import com.example.models.request.SearchRequest
import com.example.models.response.SearchResult
import java.io.File
import java.util.concurrent.TimeUnit

class SearchProcessor {
    fun search(searchRequest: SearchRequest): SearchResult {

        // Instantiating a Process to run the script
        // Starting with openCmd to open cmd shell
        val p = ProcessBuilder(openCmd)
            .directory(File(SearchConstants.scriptPath))

        // Opening cmd shell
        val proc1 = p.start()
        proc1.waitFor(2, TimeUnit.SECONDS)

        // Changing the process cmd to running the script.
        // Script will generate a result.json file in resources
        p.command(runScript(searchRequest.query, searchRequest.maxResult))

        // Running the script
        val proc2 = p.start()
        proc2.waitFor()

        // Destroying the processes
        proc1.destroy()
        proc2.destroy()

        val extractedResult = SearchResultExtractor().extract()

        return extractedResult?.mapToResponse() ?: throw SearchException()
    }

    companion object {
        private val openCmd = listOf("cmd", "cd", "/d", SearchConstants.scriptPath)
        private fun runScript(query: String) = listOf("python", "searchyt.py", query)
        private fun runScript(query: String, maxResult: Int?) = kotlin.run {
            val list = runScript(query)
            if (maxResult != null)
                list + maxResult.toString()
            else
                list
        }
    }
}