package com.noahrose.pocketlab.feature.filesystem

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object VirtualFileSystem {

    private val _files = MutableStateFlow(
        listOf(
            VirtualFile("Documents"),
            VirtualFile("Downloads"),
            VirtualFile("Projects")
        )
    )

    val files = _files.asStateFlow()

    fun createDirectory(name: String) {

        if (name.isBlank()) return

        if (_files.value.any {
                it.name.equals(name, ignoreCase = true)
            }
        ) {
            return
        }

        _files.value =
            _files.value + VirtualFile(name)

    }

}