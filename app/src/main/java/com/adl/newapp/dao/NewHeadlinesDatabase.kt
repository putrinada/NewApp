package com.adl.newapp.dao

import android.content.Context
import androidx.room.*
import com.adl.newapp.model.NewHeadlines

@Database(
    entities = [NewHeadlines::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class NewHeadlinesDatabase : RoomDatabase(){

    abstract fun getNewHeadlinesDao(): NewHeadlinesDao
    companion object{
        @Volatile
        private var instance: NewHeadlinesDatabase? =null
        private val LOCK = Any()

        operator fun invoke(context:Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance= it}
        }

        private fun createDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                NewHeadlinesDatabase::class.java,
                "article_db.db"
            ).build()

    }

}