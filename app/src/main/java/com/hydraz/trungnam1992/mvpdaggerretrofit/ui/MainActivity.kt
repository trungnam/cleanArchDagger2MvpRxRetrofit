package com.hydraz.trungnam1992.mvpdaggerretrofit.ui


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView

import com.hydraz.trungnam1992.mvpdaggerretrofit.App
import com.hydraz.trungnam1992.mvpdaggerretrofit.R
import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.datatobject.NewsItem
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.contact.MainContact

import javax.inject.Inject

class MainActivity : BaseActivity(), MainContact.MainView {

    @Inject
    internal lateinit var mainPresenter: MainPresenter

    internal lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initializeDagger() {
        val app = applicationContext as App
        app.getAppComponent().inject(this@MainActivity)
    }

    override fun initializePresenter() {
        mainPresenter.attachView(this)
        mainPresenter.setTexttoView("Hello")
        mainPresenter.getNews()
    }

    override fun initializeNewsList(news: List<NewsItem>) {
        recyclerView = findViewById(R.id.new_recycleview) as RecyclerView
        val newsAdapter = NewsAdapter(mainPresenter.getRecyclerItemListener(), news)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = newsAdapter
    }

    override fun helloCleanArchText(str: String) {
        val textView = findViewById(R.id.texthello) as TextView
        textView.text = " " + str
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.detachView(this)
    }
}
