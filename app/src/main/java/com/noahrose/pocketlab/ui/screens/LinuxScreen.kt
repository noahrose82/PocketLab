package com.noahrose.pocketlab.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.noahrose.pocketlab.feature.linux.LinuxViewModel
import androidx.compose.ui.graphics.Color

@Composable
fun LinuxScreen(
    linuxViewModel: LinuxViewModel = viewModel()
) {

    val installation by linuxViewModel.installation

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = installation.distribution.displayName,
            style = MaterialTheme.typography.headlineMedium
        )

        Text("Version: ${installation.version}")

        Text(
            text = if (installation.installed)
                "Status: Installed ✅"
            else
                "Status: Not Installed",

            color = if (installation.installed)
                Color(0xFF00C853)
            else
                Color(0xFFD32F2F),

            style = MaterialTheme.typography.titleMedium
        )

        Text("Packages: ${installation.packageCount}")

        Text("Storage: ${installation.storageUsedMb} MB")

        if (installation.installed) {
            Button(
                onClick = {
                    linuxViewModel.removeLinux()
                }
            ) {
                Text("Remove Linux")
            }
        } else {
            Button(
                onClick = {
                    linuxViewModel.installLinux()
                }
            ) {
                Text("Install Ubuntu")
            }
        }

    }

}