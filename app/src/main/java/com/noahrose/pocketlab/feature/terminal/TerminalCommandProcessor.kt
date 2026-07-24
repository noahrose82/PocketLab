package com.noahrose.pocketlab.feature.terminal

object TerminalCommandProcessor {

    fun process(
        command: String,
        output: MutableList<String>
    ) {

        output.add("atlas@cyberdeck:~$ $command")

        when (command.lowercase()) {

            "help" -> {
                output.add("Available commands:")
                output.add("")
                output.add("help")
                output.add("clear")
                output.add("whoami")
                output.add("pwd")
                output.add("ls")
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
                output.add("Documents")
                output.add("Downloads")
                output.add("Projects")
                output.add("Tools")
            }

            "status" -> {
                output.add("Atlas Cyberdeck")
                output.add("Status : ONLINE")
                output.add("Linux  : INSTALLED")
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

        if (command.lowercase() != "clear") {
            output.add("")
        }
    }
}