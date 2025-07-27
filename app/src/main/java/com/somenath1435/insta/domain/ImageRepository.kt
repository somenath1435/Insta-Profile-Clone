package com.somenath1435.insta.domain

interface ImageRepository {
    suspend fun getImages(page: Int, limit: Int): List<Image>
}