package com.androiddevs.mvvmnewsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.androiddevs.mvvmnewsapp.R
import db.ArticleDatabase
import kotlinx.android.synthetic.main.activity_news.*
import repository.NewsRepository

class NewsActivity : AppCompatActivity() {
// API_KEY = b3612bdd00c64118a33acc7e646d17d4

    lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val locale: String = applicationContext.applicationContext.getResources().getConfiguration().locale.getCountry()
        val viewModelProviderFactory = NewsViewModelProviderFactory(locale, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}
