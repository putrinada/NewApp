package com.adl.newapp.api

import com.adl.newapp.model.NewsApiRespons
import com.adl.newapp.util.Constants.Companion.Api_Key
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CallNewsApi {
     @GET("v2/top-headlines")
     suspend fun getNewsHeadlines(
         @Query("country")
         countryCode: String = "us",
        @Query("category")
         categoryCode: String,
         @Query("q")
         searchQuery:String,
         @Query("apikey")
         apikeyCode:String= Api_Key
     ):Response<NewsApiRespons>
}