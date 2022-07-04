package com.adl.newapp.dao

import androidx.room.TypeConverter
import com.adl.newapp.model.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }
    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name,name)
    }
}