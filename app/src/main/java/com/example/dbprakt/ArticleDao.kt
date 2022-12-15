package com.example.dbprakt

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArticleDao {
    @Query("SELECT * FROM Article")
    fun getAll(): List<Article>

    @Insert
    fun insertAll(vararg articles: Article)

    @Delete
    fun delete(article: Article)
}