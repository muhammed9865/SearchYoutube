package com.example.routes

import com.example.core.processor.fetch.FetchException
import com.example.core.processor.fetch.FetchProcessor
import com.example.models.request.FetchRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.fetchRoutes() {
    get("/fetch") {
        val videoId = call.request.queryParameters["video_id"]
        videoId?.let {
            val fetchRequest = FetchRequest(videoId)
            try {
                val result = FetchProcessor()
                    .fetch(fetchRequest)
                call.respond(status = HttpStatusCode.OK, result)
            }catch (e: FetchException) {

                call.respond(HttpStatusCode.BadRequest, "Video ID not found")
            }

        }
    }
}