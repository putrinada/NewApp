package com.adl.newapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.adl.newapp.model.NewHeadlines

@Dao
interface NewHeadlinesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(newHeadlines: NewHeadlines):Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<NewHeadlines>>

    @Delete
    suspend fun deleteArticle(newHeadlines: NewHeadlines)
}