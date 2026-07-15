package com.noahrose.pocketlab.feature.dashboard

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _uiState = mutableStateOf(
        DashboardUiState()
    )

    val uiState: State<DashboardUiState> = _uiState

    fun toggleLinuxInstallation() {
        val currentlyInstalled = _uiState.value.linuxInstalled
        val newInstalledState = !currentlyInstalled

        _uiState.value = _uiState.value.copy(
            linuxInstalled = newInstalledState,
            linuxStatus = if (newInstalledState) {
                SystemStatus.READY
            } else {
                SystemStatus.NOT_INSTALLED
            },
            packageCount = if (newInstalledState) {
                126
            } else {
                0
            },
            storageUsed = if (newInstalledState) {
                "1.8 GB"
            } else {
                "0 MB"
            }
        )
    }
}