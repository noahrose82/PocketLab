package com.noahrose.pocketlab.feature.workspace

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object WorkspaceRepository {

    private val _workspace = MutableStateFlow(Workspace())
    val workspace: StateFlow<Workspace> = _workspace.asStateFlow()

    fun updateLinuxInstalled(installed: Boolean) {
        _workspace.value = _workspace.value.copy(
            linuxInstalled = installed,
            packageCount = if (installed) 126 else 0,
            storageUsedMb = if (installed) 1843L else 0L
        )
    }

    fun updateStorageUsed(storageUsedMb: Long) {
        _workspace.value = _workspace.value.copy(
            storageUsedMb = storageUsedMb
        )
    }

    fun updatePackageCount(packageCount: Int) {
        _workspace.value = _workspace.value.copy(
            packageCount = packageCount
        )
    }
}