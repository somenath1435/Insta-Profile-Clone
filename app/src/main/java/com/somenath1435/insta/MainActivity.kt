package com.somenath1435.insta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.somenath1435.insta.presentation.viewmodel.ProfileViewModel
import com.somenath1435.insta.presentation.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val viewModel: ProfileViewModel = hiltViewModel()

            MaterialTheme {
                Surface {
                    AppNavHost(
                        navController = navController,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}