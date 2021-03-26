package com.androiddevs.mvvmnewsapp.ui

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.androiddevs.mvvmnewsapp.R
import db.ArticleDatabase
import kotlinx.android.synthetic.main.activity_news.*
import repository.NewsRepository
import java.util.*

class NewsActivity : AppCompatActivity() {
// API_KEY = b3612bdd00c64118a33acc7e646d17d4

    lateinit var viewModel: NewsViewModel
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val locale: Locale = getResources().getConfiguration().locales.get(0)
        val viewModelProviderFactory = NewsViewModelProviderFactory(locale.country.toString(), newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}
