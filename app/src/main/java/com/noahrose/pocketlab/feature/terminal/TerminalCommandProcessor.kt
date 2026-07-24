package com.noahrose.pocketlab.feature.terminal

import com.noahrose.pocketlab.feature.filesystem.VirtualFileSystem
object TerminalCommandProcessor {

    fun process(
        command: String,
        output: MutableList<String>
    ) {

        output.add("atlas@cyberdeck:~$ $command")

        val parts = command.split(" ", limit = 2)

        when (parts[0].lowercase()) {

            "help" -> {
                output.add("Available commands:")
                output.add("")
                output.add("help")
                output.add("clear")
                output.add("whoami")
                output.add("pwd")
                output.add("ls")
                output.add("mkdir")
                output.add("status")
                output.add("neofetch")
            }

            "clear" -> {
                output.clear()
            }

            "whoami" -> {
                output.add("atlas")
            }

            "pwd" -> {
                output.add("/home/atlas")
            }

            "ls" -> {

                VirtualFileSystem.files.value.forEach {
                    output.add(it.name)
                }

            }

            "mkdir" -> {

                if (parts.size < 2) {

                    output.add("Usage: mkdir <directory>")

                } else {

                    VirtualFileSystem.createDirectory(parts[1])

                    output.add("Directory created: ${parts[1]}")

                }

            }

            "status" -> {
                output.add("Atlas Cyberdeck")
                output.add("Status : ONLINE")
                output.add("Linux : INSTALLED")
                output.add("Terminal : ACTIVE")
            }

            "neofetch" -> {
                output.add("Atlas Cyberdeck v0.6.0 \"Forge\"")
                output.add("OS      : Atlas Linux")
                output.add("Kernel  : 6.1")
                output.add("Shell   : Atlas Terminal")
                output.add("User    : atlas")
            }

            else -> {
                output.add("Command not found: $command")
            }
        }
    }
}