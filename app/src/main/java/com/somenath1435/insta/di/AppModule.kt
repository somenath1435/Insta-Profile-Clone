package com.somenath1435.insta.di

import com.somenath1435.insta.data.remote.ApiService
import com.somenath1435.insta.data.repository.ImageRepositoryImpl
import com.somenath1435.insta.domain.repository.ImageRepository
import com.somenath1435.insta.domain.usecase.GetImagesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://picsum.photos/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideImageRepository(apiService: ApiService): ImageRepository =
        ImageRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun provideGetImagesUseCase(repository: ImageRepository): GetImagesUseCase =
        GetImagesUseCase(repository)
}