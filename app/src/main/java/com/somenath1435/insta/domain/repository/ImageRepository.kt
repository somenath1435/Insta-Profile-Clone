package com.somenath1435.insta.domain.repository

import com.somenath1435.insta.domain.model.Image

interface ImageRepository {
    suspend fun getImages(page: Int, limit: Int): List<Image>
}