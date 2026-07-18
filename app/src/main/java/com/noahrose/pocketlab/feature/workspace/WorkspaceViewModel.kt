package com.noahrose.pocketlab.feature.workspace

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

class WorkspaceViewModel : ViewModel() {

    val workspace: StateFlow<Workspace> = WorkspaceRepository.workspace

    fun setLinuxInstalled(installed: Boolean) {
        WorkspaceRepository.updateLinuxInstalled(installed)
    }

    fun setStorageUsed(storageUsedMb: Long) {
        WorkspaceRepository.updateStorageUsed(storageUsedMb)
    }

    fun setPackageCount(packageCount: Int) {
        WorkspaceRepository.updatePackageCount(packageCount)
    }
}