package com.somenath1435.insta.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.somenath1435.insta.presentation.viewmodel.ProfileViewModel
import com.somenath1435.insta.presentation.screens.ProfileScreen
import com.somenath1435.insta.presentation.screens.StoryPlayerScreen

@Composable
fun AppNavHost(navController: NavHostController, viewModel: ProfileViewModel) {
    NavHost(navController = navController, startDestination = Screen.Profile.route) {
        composable(Screen.Profile.route) {
            ProfileScreen(viewModel = viewModel, navController = navController)
        }
        composable(Screen.StoryPlayer.route) { backStackEntry ->
            val storyId = backStackEntry.arguments?.getString("storyId")?.toIntOrNull()
            storyId?.let {
                StoryPlayerScreen(storyId = it)
            }
        }
    }
}