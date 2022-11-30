package com.example

import com.example.core.processor.search.SearchProcessor
import io.ktor.server.application.*
import com.example.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    val processor = SearchProcessor()
    configureSerialization()
    configureMonitoring()
    configureRouting(processor)
}
