package com.pesan.mvvmapp.respository

import android.widget.SearchView
import com.pesan.mvvmapp.database.ArticleDataBase
import com.pesan.mvvmapp.model.Article
import com.pesan.mvvmapp.network.RetrofitInstance

class NewsRepository(val db: ArticleDataBase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticle()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}