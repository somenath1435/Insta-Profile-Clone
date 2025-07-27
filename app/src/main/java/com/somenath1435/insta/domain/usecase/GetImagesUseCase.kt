package com.somenath1435.insta.domain.usecase

import com.somenath1435.insta.domain.model.Image
import com.somenath1435.insta.domain.repository.ImageRepository

class GetImagesUseCase(private val repo: ImageRepository) {
    suspend fun execute(page: Int, limit: Int): List<Image> = repo.getImages(page, limit)
}