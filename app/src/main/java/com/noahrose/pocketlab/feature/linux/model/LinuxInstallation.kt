package com.noahrose.pocketlab.feature.linux.model

data class LinuxInstallation(

    val distribution: LinuxDistribution,

    val version: String,

    val installed: Boolean,

    val running: Boolean,

    val packageCount: Int,

    val storageUsedMb: Long

)