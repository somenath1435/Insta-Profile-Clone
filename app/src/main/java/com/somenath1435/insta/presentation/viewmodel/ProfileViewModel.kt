package com.somenath1435.insta.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.somenath1435.insta.domain.usecase.GetImagesUseCase
import com.somenath1435.insta.domain.model.Image
import kotlinx.coroutines.launch

class ProfileViewModel(private val getImagesUseCase: GetImagesUseCase) : ViewModel() {
    var images by mutableStateOf<List<Image>>(emptyList())
        private set

    init {
        loadImages()
    }

    private fun loadImages() {
        viewModelScope.launch {
            getImagesUseCase.execute(page = 1, limit = 30).also { images = it }
        }
    }
}