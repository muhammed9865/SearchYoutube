package com.example.plugins

import com.example.core.processor.SearchProcessor
import com.example.routes.searchRoutes
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting(processor: SearchProcessor) {

    routing {
        searchRoutes(processor)
    }
}
