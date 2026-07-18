package com.noahrose.pocketlab.feature.linux.repository

import com.noahrose.pocketlab.feature.linux.model.LinuxDistribution
import com.noahrose.pocketlab.feature.linux.model.LinuxInstallation

object LinuxRepository {

    private var installation = LinuxInstallation(
        distribution = LinuxDistribution.UBUNTU,
        version = "24.04 LTS",
        installed = false,
        running = false,
        packageCount = 0,
        storageUsedMb = 0
    )

    fun getInstallation(): LinuxInstallation = installation

    fun installLinux() {
        installation = installation.copy(
            installed = true,
            packageCount = 125,
            storageUsedMb = 1850
        )
    }

    fun removeLinux() {
        installation = installation.copy(
            installed = false,
            running = false,
            packageCount = 0,
            storageUsedMb = 0
        )
    }
}