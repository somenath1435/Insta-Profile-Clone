package com.somenath1435.insta.domain

class GetImagesUseCase(private val repo: ImageRepository) {
    suspend fun execute(page: Int, limit: Int): List<Image> = repo.getImages(page, limit)
}