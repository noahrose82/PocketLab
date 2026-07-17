package com.noahrose.pocketlab.feature.boot

data class BootUiState(
    val currentStep: BootStep = BootStep.STARTING,
    val progress: Float = 0f,
    val isComplete: Boolean = false
)

enum class BootStep(val displayText: String) {
    STARTING("Initializing Atlas Cyberdeck"),
    WORKSPACE("Loading workspace"),
    LINUX("Loading Linux manager"),
    TERMINAL("Loading terminal"),
    SSH("Loading SSH services"),
    FILE_SYSTEM("Loading file system"),
    READY("System ready")
}