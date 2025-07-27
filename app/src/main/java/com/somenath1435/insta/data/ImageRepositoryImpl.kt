package com.somenath1435.insta.data

import com.somenath1435.insta.domain.Image
import com.somenath1435.insta.domain.ImageRepository

class ImageRepositoryImpl(private val api: ApiService) : ImageRepository {
    override suspend fun getImages(page: Int, limit: Int): List<Image> {
        return api.getImages(page, limit).map { Image(it.id, it.download_url) }
    }
}