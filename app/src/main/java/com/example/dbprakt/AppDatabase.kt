package com.example.dbprakt

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Article::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao

    companion object{
        fun getDatabase(context:Context):AppDatabase
        {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java, "Article"
            ).allowMainThreadQueries().build()
        }
    }
}