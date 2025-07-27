package com.somenath1435.insta.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.somenath1435.insta.presentation.ProfileViewModel
import com.somenath1435.insta.presentation.components.HighlightsSection
import com.somenath1435.insta.presentation.components.InstagramTopBar
import com.somenath1435.insta.presentation.components.PostGrid
import com.somenath1435.insta.presentation.components.ProfileHeader

@Composable
fun ProfileScreen(viewModel: ProfileViewModel, navController: NavController) {
    val images = viewModel.images

    Scaffold(topBar = { InstagramTopBar() }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            ProfileHeader()
            Spacer(Modifier.height(12.dp))
            HighlightsSection(navController)
            Spacer(Modifier.height(12.dp))
            PostGrid(images = images)
        }
    }
}