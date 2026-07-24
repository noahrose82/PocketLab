package com.noahrose.pocketlab.feature.terminal

data class TerminalUiState(

    val output: List<String> = listOf(
        "Atlas Cyberdeck Terminal",
        "Type 'help' to begin.",
        ""
    ),

    val currentCommand: String = ""

)