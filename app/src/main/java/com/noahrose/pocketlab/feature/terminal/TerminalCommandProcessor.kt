package com.noahrose.pocketlab.feature.terminal

import com.noahrose.pocketlab.feature.filesystem.VirtualFileSystem

object TerminalCommandProcessor {

    fun process(
        command: String,
        output: MutableList<String>
    ) {

        val currentPath = VirtualFileSystem.currentPath.value

        output.add("atlas@cyberdeck:$currentPath$ $command")

        val parts = command.trim().split(" ", limit = 2)

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
                output.add("cd")
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
                output.add(
                    VirtualFileSystem.currentPath.value
                        .replace("~", "/home/atlas")
                )
            }

            "ls" -> {
                VirtualFileSystem.files.value
                    .filter {
                        it.path == VirtualFileSystem.currentPath.value
                    }
                    .forEach {
                        output.add(it.name)
                    }
            }

            "mkdir" -> {
                if (parts.size < 2 || parts[1].isBlank()) {
                    output.add("Usage: mkdir <directory>")
                } else {
                    VirtualFileSystem.createDirectory(parts[1].trim())
                    output.add("Directory created: ${parts[1].trim()}")
                }
            }

            "cd" -> {
                if (parts.size < 2 || parts[1].isBlank()) {
                    output.add("Usage: cd <directory>")
                } else {
                    val changed =
                        VirtualFileSystem.changeDirectory(parts[1].trim())

                    if (!changed) {
                        output.add(
                            "cd: ${parts[1].trim()}: No such directory"
                        )
                    }
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