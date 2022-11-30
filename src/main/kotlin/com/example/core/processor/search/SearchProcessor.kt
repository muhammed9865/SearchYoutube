package com.example.core.processor.search

import com.example.core.mapper.mapToResponse
import com.example.core.processor.CommandConstants
import com.example.core.processor.CommandRunner
import com.example.models.request.SearchRequest
import com.example.models.response.SearchResult

class SearchProcessor {
    fun search(searchRequest: SearchRequest): SearchResult {

        CommandRunner(
            commands = runScript(searchRequest.query, searchRequest.maxResult)
        ).run().also {
            it.destroy()
        }


        val extractedResult = SearchResultExtractor().extract()
        return extractedResult?.mapToResponse() ?: throw SearchException()
    }

    companion object {

        private fun runScript(query: String) = listOf("python", CommandConstants.SEARCH_SCRIPT, query)
        private fun runScript(query: String, maxResult: Int?) = kotlin.run {
            val cmdList = runScript(query)
            if (maxResult != null)
                // append the maxResult parameter to command
                cmdList + maxResult.toString()
            else
                cmdList
        }
    }
}