package com.noahrose.pocketlab.feature.dashboard

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
import com.noahrose.pocketlab.ui.components.SmallStatusCard
import com.noahrose.pocketlab.ui.components.StatusCard
import com.noahrose.pocketlab.ui.components.SectionHeader
import com.noahrose.pocketlab.ui.components.PocketTopBar
import com.noahrose.pocketlab.ui.components.ActionCard
@Composable
fun DashboardScreen(
    onNavigateToTerminal: () -> Unit,
    onNavigateToLinux: () -> Unit,
    onNavigateToFiles: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    var linuxInstalled by remember { mutableStateOf(false) }

    Scaffold { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {

            PocketTopBar(
                title = "PocketLab",
                subtitle = "Your Cyberdeck. Anywhere."
            )

            Spacer(modifier = Modifier.height(24.dp))

            SectionHeader(title = "System Status")

            Spacer(modifier = Modifier.height(12.dp))

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
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    linuxInstalled = !linuxInstalled
                }
            ) {

                Text(
                    if (linuxInstalled)
                        "Remove Linux"
                    else
                        "Install Linux"
                )

            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "This button is currently a demonstration. In Phase 3 it will install a real Linux environment.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(28.dp))

            SectionHeader(title = "Quick Actions")

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ActionCard(
                    modifier = Modifier.weight(1f),
                    title = "Terminal",
                    symbol = ">_",
                    onClick = onNavigateToTerminal
                )

                ActionCard(
                    modifier = Modifier.weight(1f),
                    title = "Linux",
                    symbol = "◆",
                    onClick = onNavigateToLinux
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ActionCard(
                    modifier = Modifier.weight(1f),
                    title = "Files",
                    symbol = "▣",
                    onClick = onNavigateToFiles
                )

                ActionCard(
                    modifier = Modifier.weight(1f),
                    title = "Settings",
                    symbol = "⚙",
                    onClick = onNavigateToSettings
                )
            }

        }

    }

}