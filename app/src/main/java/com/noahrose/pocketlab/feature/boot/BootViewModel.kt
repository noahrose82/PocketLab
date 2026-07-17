package com.noahrose.pocketlab.feature.boot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BootViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(BootUiState())
    val uiState: StateFlow<BootUiState> = _uiState.asStateFlow()

    init {
        beginBootSequence()
    }

    private fun beginBootSequence() {
        viewModelScope.launch {
            val steps = listOf(
                BootStep.STARTING,
                BootStep.WORKSPACE,
                BootStep.LINUX,
                BootStep.TERMINAL,
                BootStep.SSH,
                BootStep.FILE_SYSTEM,
                BootStep.READY
            )

            steps.forEachIndexed { index, step ->
                _uiState.value = BootUiState(
                    currentStep = step,
                    progress = (index + 1).toFloat() / steps.size,
                    isComplete = step == BootStep.READY
                )

                delay(
                    timeMillis = if (step == BootStep.READY) {
                        800L
                    } else {
                        500L
                    }
                )
            }
        }
    }
}