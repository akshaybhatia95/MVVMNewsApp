package repository

import api.RetrofitInstance
import db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun getSearchNews(query: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(query, pageNumber)
}