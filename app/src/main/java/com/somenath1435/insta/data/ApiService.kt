package com.somenath1435.insta.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("list")
    suspend fun getImages(@Query("page") page: Int, @Query("limit") limit: Int): List<ImageDto>
}