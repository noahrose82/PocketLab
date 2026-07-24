package com.noahrose.pocketlab.feature.terminal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TerminalViewModel : ViewModel() {

    var uiState by mutableStateOf(TerminalUiState())
        private set

    fun updateCommand(command: String) {
        uiState = uiState.copy(
            currentCommand = command
        )
    }

    fun executeCommand() {

        val command = uiState.currentCommand.trim()

        if (command.isEmpty()) {
            return
        }

        val output = uiState.output.toMutableList()

        TerminalCommandProcessor.process(
            command = command,
            output = output
        )

        uiState = uiState.copy(
            output = output,
            currentCommand = ""
        )
    }
}