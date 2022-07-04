package com.adl.newapp.repository

import com.adl.newapp.dao.NewHeadlinesDatabase
import com.adl.newapp.util.RetrofitInstance
import retrofit2.http.Query

class NewsAppRepository(
    val db: NewHeadlinesDatabase
) {
    suspend fun getNewsHeadlines(countryCode:String,categoryCode: String,searchQuery: String) =
        RetrofitInstance.getAPIService.getNewsHeadlines(countryCode,categoryCode,searchQuery)

}