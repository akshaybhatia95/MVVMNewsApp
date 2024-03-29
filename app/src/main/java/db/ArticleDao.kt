package db

import androidx.lifecycle.LiveData
import androidx.room.*
import model.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * from articles")
    fun getAllArticles(): LiveData< List<Article> >

    @Delete
    suspend fun deleteArticle(article: Article)
}