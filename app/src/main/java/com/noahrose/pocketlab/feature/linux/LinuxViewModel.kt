package com.noahrose.pocketlab.feature.linux

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.noahrose.pocketlab.feature.linux.model.LinuxInstallation
import com.noahrose.pocketlab.feature.linux.repository.LinuxRepository

class LinuxViewModel : ViewModel() {

    private val _installation = mutableStateOf(
        LinuxRepository.getInstallation()
    )

    val installation: State<LinuxInstallation> = _installation

    fun installLinux() {
        LinuxRepository.installLinux()
        refreshInstallation()
    }

    fun removeLinux() {
        LinuxRepository.removeLinux()
        refreshInstallation()
    }

    private fun refreshInstallation() {
        _installation.value = LinuxRepository.getInstallation()
    }
}