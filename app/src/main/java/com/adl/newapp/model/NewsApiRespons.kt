package com.adl.newapp.model

data class NewsApiRespons(
    val articles: List<NewHeadlines>,
    val status: String,
    val totalResults: Int
)
