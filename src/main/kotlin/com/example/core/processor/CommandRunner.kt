package com.example.core.processor

import java.io.File
import java.util.concurrent.TimeUnit

class CommandRunner(
    private val commands: List<String>
) {

    fun run() : Process {
        // Instantiating a Process to run the script
        // Starting with openCmd to open cmd shell
        val p = ProcessBuilder(openCmd)
            .directory(File(CommandConstants.scriptsPath))

        // Opening cmd shell
        val process1 = p.start()
        process1.waitFor(2, TimeUnit.SECONDS)


        // Changing the process cmd to commands list.
        p.command(commands)

        // Running the script
        val process2 = p.start()
        process2.waitFor()


        // Destroying the cmd shell process
        process1.destroy()

        // Returning the command process when contains output streams,
        // Must be destroyed manually after dealing with its properties.
        return process2
    }

    companion object {
        private val openCmd = listOf("cmd", "cd", "/d", CommandConstants.scriptsPath)

    }

}