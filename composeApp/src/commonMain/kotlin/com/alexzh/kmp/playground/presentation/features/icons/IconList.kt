package com.alexzh.kmp.playground.presentation.features.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.alexzh.kmp.playground.Platform
import com.alexzh.kmp.playground.platform
import kotlinmultiplatformplayground.composeapp.generated.resources.Res
import kotlinmultiplatformplayground.composeapp.generated.resources.ic_back_ios
import kotlinmultiplatformplayground.composeapp.generated.resources.ic_delete_ios
import kotlinmultiplatformplayground.composeapp.generated.resources.ic_edit_ios
import org.jetbrains.compose.resources.vectorResource

@Composable
fun IconList(
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Demo: Icons") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = BackIcon,
                            contentDescription = "Back"
                        )
                    }
                },
                backgroundColor = Color.White
            )
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(modifier = Modifier.size(100.dp)) {
                Image(
                    imageVector = EditIcon,
                    contentDescription = "Edit"
                )
            }

            Card(modifier = Modifier.size(100.dp)) {
                Image(
                    imageVector = DeleteIcon,
                    contentDescription = "Delete"
                )
            }
        }
    }
}

val BackIcon: ImageVector
    @Composable
    get() {
        return when (platform) {
            Platform.Android -> Icons.AutoMirrored.Default.ArrowBack
            Platform.Ios -> vectorResource(Res.drawable.ic_back_ios)
            else -> Icons.AutoMirrored.Default.KeyboardArrowLeft
        }
    }

val EditIcon: ImageVector
    @Composable
    get() {
        return when (platform) {
            Platform.Android -> Icons.Outlined.Edit
            Platform.Ios -> vectorResource(Res.drawable.ic_edit_ios)
            else -> Icons.Filled.Edit
        }
    }

val DeleteIcon: ImageVector
    @Composable
    get() {
        return when (platform) {
            Platform.Android -> Icons.Outlined.Delete
            Platform.Ios -> vectorResource(Res.drawable.ic_delete_ios)
            else -> Icons.Filled.Delete
        }
    }