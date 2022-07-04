package com.adl.newapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adl.newapp.repository.NewsAppRepository

class NewsAppViewModelProviderFactory (
    val newsAppRepository: NewsAppRepository
        ): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsAppViewModel(newsAppRepository)as T
    }

}