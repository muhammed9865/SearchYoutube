package com.example.plugins

import com.example.core.processor.search.SearchProcessor
import com.example.routes.searchRoutes
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting(processor: SearchProcessor) {

    routing {
        searchRoutes(processor)
    }
}
