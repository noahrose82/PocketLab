package com.noahrose.pocketlab.feature.filesystem

data class VirtualFile(

    val name: String,

    val path: String = "~",

    val isDirectory: Boolean = true

)