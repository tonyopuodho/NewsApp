package com.example.newsapp.di

import com.example.newsapp.data.remote.NewsApi
import com.example.newsapp.data.remote.NewsApi.Companion.BASE_URL
import com.example.newsapp.data.repository.NewsRepositoryImpl
import com.example.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
/*
 Providing app module for calling an api and dependency injection
*/
@Module
@InstallIn(SingletonComponent::class)
object NewsModule {
    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(NewsApi::class.java)
    }

    @Provides
    fun provideNewsRepository(newsApi: NewsApi): NewsRepository{
        return NewsRepositoryImpl(newsApi)
    }
}