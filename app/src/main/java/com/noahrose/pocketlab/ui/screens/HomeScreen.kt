package com.noahrose.pocketlab.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    var linuxInstalled by remember { mutableStateOf(false) }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            Text(
                text = "PocketLab",
                style = MaterialTheme.typography.headlineLarge
            )

            Text(
                text = "Portable Linux Workspace",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(24.dp))

            StatusCard(
                title = "Linux Environment",
                value = if (linuxInstalled) "Installed" else "Not Installed",
                symbol = if (linuxInstalled) "●" else "○"
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SmallStatusCard(
                    modifier = Modifier.weight(1f),
                    title = "Packages",
                    value = "0"
                )

                SmallStatusCard(
                    modifier = Modifier.weight(1f),
                    title = "Storage",
                    value = "0 MB"
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SmallStatusCard(
                    modifier = Modifier.weight(1f),
                    title = "Terminal",
                    value = "Ready"
                )

                SmallStatusCard(
                    modifier = Modifier.weight(1f),
                    title = "Architecture",
                    value = "ARM64"
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            Button(
                onClick = {
                    linuxInstalled = !linuxInstalled
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    if (linuxInstalled) {
                        "Remove Linux"
                    } else {
                        "Install Linux"
                    }
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "The installation button is currently a demonstration. We will connect it to the real Linux installer later.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun StatusCard(
    title: String,
    value: String,
    symbol: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = value,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Text(
                text = symbol,
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}

@Composable
private fun SmallStatusCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = value,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}