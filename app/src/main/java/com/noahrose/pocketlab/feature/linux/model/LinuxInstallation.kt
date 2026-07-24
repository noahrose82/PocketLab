package com.noahrose.pocketlab.feature.linux.model

data class LinuxInstallation(

    val distribution: LinuxDistribution,

    val version: String,

    val installed: Boolean,

    val running: Boolean,

    val packageCount: Int,

    val storageUsedMb: Long,

    val isInstalling: Boolean = false,

    val installationProgress: Float = 0f,

    val installationStep: String = "Ready"

)