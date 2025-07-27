package com.somenath1435.insta.presentation.navigation

sealed class Screen(val route: String) {
    object Profile : Screen("profile")
    object StoryPlayer : Screen("storyPlayer/{storyId}") {
        fun createRoute(storyId: Int) = "storyPlayer/$storyId"
    }
}