package com.example.routes

import com.example.core.processor.SearchException
import com.example.core.processor.SearchProcessor
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.searchRoutes(processor: SearchProcessor) {

    get("{query?}") {
        val query = call.request.queryParameters["query"]
        if (query == null) {
            call.respond(status = HttpStatusCode.BadRequest, "Query can't be null")
            return@get
        }

        try {
            val searchResult = processor.search(query)
            call.respond(status = HttpStatusCode.OK, searchResult)
        } catch (e: SearchException) {
            call.respond(status = HttpStatusCode.InternalServerError, "Something went wrong")
        }


    }
}