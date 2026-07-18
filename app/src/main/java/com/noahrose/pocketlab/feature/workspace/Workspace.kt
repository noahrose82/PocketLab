package com.noahrose.pocketlab.feature.workspace

data class Workspace(
    val name: String = "Default Workspace",
    val linuxInstalled: Boolean = false,
    val architecture: String = "ARM64",
    val storageUsedMb: Long = 0L,
    val packageCount: Int = 0,
    val terminalReady: Boolean = true
)