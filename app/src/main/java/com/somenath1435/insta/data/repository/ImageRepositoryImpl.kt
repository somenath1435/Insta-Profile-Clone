package com.somenath1435.insta.data.repository

import com.somenath1435.insta.data.remote.ApiService
import com.somenath1435.insta.domain.model.Image
import com.somenath1435.insta.domain.repository.ImageRepository

class ImageRepositoryImpl(private val api: ApiService) : ImageRepository {
    override suspend fun getImages(page: Int, limit: Int): List<Image> {
        return api.getImages(page, limit).map { Image(it.id, it.download_url) }
    }
}