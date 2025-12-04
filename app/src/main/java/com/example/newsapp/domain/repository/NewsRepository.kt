package com.example.newsapp.domain.repository

import com.example.newsapp.domain.model.Article
import com.example.newsapp.util.Resource

interface NewsRepository {
    suspend fun getTopHeadline(
        category: String
    ): Resource<List<Article>>
}