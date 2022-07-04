package com.adl.newapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adl.newapp.model.NewHeadlines
import com.adl.newapp.model.NewsApiRespons
import com.adl.newapp.repository.NewsAppRepository
import com.adl.newapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsAppViewModel (
    val newsAppRepository: NewsAppRepository): ViewModel(){

    val headlinesNews = MutableLiveData<Resource<NewsApiRespons>>()
    var headlinesCategory = "general"


    fun getNewsHeadlines(countryCode:String,searchQuery:String) = viewModelScope.launch {
        headlinesNews.postValue(Resource.Loading())
        val respons = newsAppRepository.getNewsHeadlines(countryCode,searchQuery,headlinesCategory)
        headlinesNews.postValue(headlinesResponse(respons))
    }
    private fun headlinesResponse(response: Response<NewsApiRespons> ):Resource<NewsApiRespons>{
        if (response.isSuccessful) {
            response.body()?.let { resultRespons ->
                return Resource.Success(resultRespons)
            }
        }
        return Resource.Error(response.message())
    }


}