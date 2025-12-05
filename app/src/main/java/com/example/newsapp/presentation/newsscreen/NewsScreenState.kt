package com.example.newsapp.presentation.newsscreen

import com.example.newsapp.domain.model.Article

data class NewsScreenState(
    val isLoading: Boolean = false,
    val article: List<Article> = emptyList(),
    val error: String? = null,
    val selectedArticle: Article? = null,
    val category: String = "General"
)