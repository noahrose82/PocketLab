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

    private val _currentPath = MutableStateFlow("~")

    val currentPath = _currentPath.asStateFlow()

    fun createDirectory(name: String) {

        if (name.isBlank()) return

        if (_files.value.any {
                it.name.equals(name, ignoreCase = true) &&
                        it.path == _currentPath.value
            }
        ) {
            return
        }

        _files.value =
            _files.value + VirtualFile(
                name = name,
                path = _currentPath.value
            )
    }

    fun changeDirectory(name: String): Boolean {

        val directoryExists = _files.value.any {
            it.name.equals(name, ignoreCase = true) &&
                    it.path == _currentPath.value &&
                    it.isDirectory
        }

        if (!directoryExists) {
            return false
        }

        _currentPath.value =
            if (_currentPath.value == "~") {
                "~/$name"
            } else {
                "${_currentPath.value}/$name"
            }

        return true
    }
}