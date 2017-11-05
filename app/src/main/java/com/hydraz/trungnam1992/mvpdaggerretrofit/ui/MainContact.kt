package com.hydraz.trungnam1992.mvpdaggerretrofit.ui

import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.datatobject.NewsItem

/**
 * Created by trungnam1992 on 11/4/17.
 */
public interface MainContact  {

    interface MainView : BaseView{
        fun initializeNewsList(news: List<NewsItem>)

        fun helloCleanArchText(str: String)

    }

    interface Presenter : BasePresenter<MainView>{
        fun getNews()
        fun setTexttoView(str : String)
    }
}