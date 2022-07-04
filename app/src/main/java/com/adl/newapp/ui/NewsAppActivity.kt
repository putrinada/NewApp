package com.adl.newapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.newapp.R
import com.adl.newapp.adapter.NewsAppAdapter
import com.adl.newapp.dao.NewHeadlinesDatabase
import com.adl.newapp.model.NewHeadlines
import com.adl.newapp.repository.NewsAppRepository
import kotlinx.android.synthetic.main.activity_news_app.*

class NewsAppActivity : AppCompatActivity() {
    private lateinit var viewModel: NewsAppViewModel
    private lateinit var newsAppAdapter: NewsAppAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_app)

     //   val newsAppRepository = NewsAppRepository(NewHeadlinesDatabase(this))
      //  val viewModelProviderFactory =NewsAppViewModelProviderFactory(newsAppRepository)
      //  viewModel=ViewModelProvider(this,viewModelProviderFactory).get(NewsAppViewModel::class.java)
        viewModel = ViewModelProvider(this).get(NewsAppViewModel::class.java)

        initUI()
    }

    private fun initUI() {
        RvNewsApp.layoutManager = LinearLayoutManager(this)
        RvNewsApp.adapter = NewsAppAdapter{
            val intent = Intent(this, NewsAppDetailActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }
        viewModel.headlinesNews.observe(this, Observer { list ->
            (RvNewsApp.adapter as NewsAppAdapter).setData(list as List<NewHeadlines>)
        })

    }
}