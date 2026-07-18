package com.noahrose.pocketlab.feature.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noahrose.pocketlab.feature.workspace.Workspace
import com.noahrose.pocketlab.feature.workspace.WorkspaceRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DashboardViewModel : ViewModel() {

    val uiState: StateFlow<DashboardUiState> =
        WorkspaceRepository.workspace
            .map { workspace ->
                workspace.toDashboardUiState()
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = WorkspaceRepository.workspace.value
                    .toDashboardUiState()
            )

    fun toggleLinuxInstallation() {
        val currentlyInstalled =
            WorkspaceRepository.workspace.value.linuxInstalled

        WorkspaceRepository.updateLinuxInstalled(
            installed = !currentlyInstalled
        )
    }
}

private fun Workspace.toDashboardUiState(): DashboardUiState {
    return DashboardUiState(
        linuxInstalled = linuxInstalled,
        linuxStatus = if (linuxInstalled) {
            SystemStatus.READY
        } else {
            SystemStatus.NOT_INSTALLED
        },
        terminalStatus = if (terminalReady) {
            SystemStatus.READY
        } else {
            SystemStatus.NOT_INSTALLED
        },
        packageCount = packageCount,
        storageUsed = formatStorage(storageUsedMb),
        architecture = architecture
    )
}

private fun formatStorage(storageUsedMb: Long): String {
    return if (storageUsedMb >= 1024L) {
        String.format("%.1f GB", storageUsedMb / 1024.0)
    } else {
        "$storageUsedMb MB"
    }
}