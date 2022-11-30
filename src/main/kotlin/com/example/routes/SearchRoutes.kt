package com.example.routes

import com.example.core.processor.SearchException
import com.example.core.processor.SearchProcessor
import com.example.models.request.SearchRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.searchRoutes(processor: SearchProcessor) {

    get {
        val query = call.request.queryParameters["query"]
        val maxResult = call.request.queryParameters["max_result"]

        if (query == null) {
            call.respond(status = HttpStatusCode.BadRequest, "Query can't be null")
            return@get
        }

        try {
            // Constructing the request from parameters
            val searchRequest = SearchRequest(
                query = query,
                maxResult = maxResult?.toIntOrNull()
            )
            val searchResult = processor.search(searchRequest)
            call.respond(status = HttpStatusCode.OK, searchResult)
        } catch (e: SearchException) {
            call.respond(status = HttpStatusCode.InternalServerError, "Something went wrong")
        }

    }
}