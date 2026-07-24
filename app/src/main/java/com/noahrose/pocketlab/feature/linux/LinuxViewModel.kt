package com.noahrose.pocketlab.feature.linux

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noahrose.pocketlab.feature.linux.model.LinuxInstallation
import com.noahrose.pocketlab.feature.linux.repository.LinuxRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LinuxViewModel : ViewModel() {

    private val _installation = mutableStateOf(
        LinuxRepository.getInstallation()
    )

    val installation: State<LinuxInstallation> = _installation

    fun installLinux() {
        if (_installation.value.isInstalling || _installation.value.installed) {
            return
        }

        viewModelScope.launch {
            LinuxRepository.startInstallation()
            refreshInstallation()

            updateInstallation(
                progress = 0.20f,
                step = "Preparing installation..."
            )
            delay(800)

            updateInstallation(
                progress = 0.40f,
                step = "Downloading packages..."
            )
            delay(1000)

            updateInstallation(
                progress = 0.65f,
                step = "Installing packages..."
            )
            delay(1200)

            updateInstallation(
                progress = 0.85f,
                step = "Configuring system..."
            )
            delay(900)

            updateInstallation(
                progress = 0.95f,
                step = "Cleaning up..."
            )
            delay(700)

            LinuxRepository.completeInstallation()
            refreshInstallation()
        }
    }

    fun removeLinux() {
        if (_installation.value.isInstalling) {
            return
        }

        LinuxRepository.removeLinux()
        refreshInstallation()
    }

    private fun updateInstallation(
        progress: Float,
        step: String
    ) {
        val updatedInstallation = LinuxRepository.getInstallation().copy(
            isInstalling = true,
            installationProgress = progress,
            installationStep = step
        )

        LinuxRepository.updateInstallation(updatedInstallation)
        refreshInstallation()
    }

    private fun refreshInstallation() {
        _installation.value = LinuxRepository.getInstallation()
    }
}