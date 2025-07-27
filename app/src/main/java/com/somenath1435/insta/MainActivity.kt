package com.somenath1435.insta

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.somenath1435.insta.data.ApiService
import com.somenath1435.insta.data.ImageRepositoryImpl
import com.somenath1435.insta.domain.GetImagesUseCase
import com.somenath1435.insta.presentation.ProfileViewModel
import com.somenath1435.insta.presentation.navigation.AppNavHost
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://picsum.photos/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        val imageRepository = ImageRepositoryImpl(apiService)
        val getImagesUseCase = GetImagesUseCase(imageRepository)

        // Create ViewModel using a custom factory
        val viewModel = ViewModelProvider(
            this,
            ProfileViewModelFactory(getImagesUseCase)
        )[ProfileViewModel::class.java]

        setContent {
            val navController = rememberNavController()

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

class ProfileViewModelFactory(
    private val getImagesUseCase: GetImagesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(getImagesUseCase) as T
    }
}