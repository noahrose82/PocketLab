package com.noahrose.pocketlab.feature.linux.model

enum class LinuxDistribution(
    val displayName: String
) {
    UBUNTU("Ubuntu"),
    DEBIAN("Debian"),
    FEDORA("Fedora"),
    ARCH("Arch Linux"),
    ALPINE("Alpine Linux")
}