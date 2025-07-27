package com.somenath1435.insta.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Instagram",
                fontFamily = FontFamily.Cursive,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.Add, contentDescription = "Add Post")
            }
            IconButton(onClick = { }) {
                Icon(Icons.Default.Notifications, contentDescription = "Notifications")
            }
            IconButton(onClick = { }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },
    )
}