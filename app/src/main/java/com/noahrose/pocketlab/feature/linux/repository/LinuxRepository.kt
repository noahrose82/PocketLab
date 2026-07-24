package com.noahrose.pocketlab.feature.linux.repository

import com.noahrose.pocketlab.feature.linux.model.LinuxDistribution
import com.noahrose.pocketlab.feature.linux.model.LinuxInstallation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object LinuxRepository {

    private val _installation = MutableStateFlow(
        LinuxInstallation(
            distribution = LinuxDistribution.UBUNTU,
            version = "24.04 LTS",
            installed = false,
            running = false,
            packageCount = 0,
            storageUsedMb = 0
        )
    )

    val installation: StateFlow<LinuxInstallation> =
        _installation.asStateFlow()

    fun getInstallation(): LinuxInstallation =
        _installation.value

    fun updateInstallation(updated: LinuxInstallation) {
        _installation.value = updated
    }

    fun startInstallation() {
        _installation.value = _installation.value.copy(
            isInstalling = true,
            installationProgress = 0f,
            installationStep = "Preparing installation..."
        )
    }

    fun completeInstallation() {
        _installation.value = _installation.value.copy(
            installed = true,
            running = false,
            packageCount = 125,
            storageUsedMb = 1850,
            isInstalling = false,
            installationProgress = 1f,
            installationStep = "Installation complete"
        )
    }

    fun removeLinux() {
        _installation.value = _installation.value.copy(
            installed = false,
            running = false,
            packageCount = 0,
            storageUsedMb = 0,
            isInstalling = false,
            installationProgress = 0f,
            installationStep = "Ready"
        )
    }
}