package com.example.core.processor.fetch

import com.example.core.processor.CommandConstants
import com.example.core.processor.CommandRunner
import com.example.models.request.FetchRequest
import com.example.models.response.fetch.PlayableVideo

class FetchProcessor {

    fun fetch(fetchRequest: FetchRequest) : PlayableVideo {

        val process = CommandRunner(
            commands = scriptCommands(fetchRequest)
        ).run()

        val extractedResult = FetchResultExtractor.extract(process)

        return extractedResult ?: throw FetchException("Couldn't fetch information")
    }

    private fun scriptCommands(fetchRequest: FetchRequest) = fetchCmds + fetchRequest.video_id

    companion object {
        private val fetchCmds = listOf("python", CommandConstants.FETCH_SCRIPT)

    }
}