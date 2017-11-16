package com.hydraz.trungnam1992.mvpdaggerretrofit.ui.contact

import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.datatobject.NewsItem
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.BaseView
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.Listener.RecyclerItemListener

/**
 * Created by trungnam1992 on 11/4/17.
 */
public interface MainContact  {

    interface MainView : BaseView {
        fun initializeNewsList(news: List<NewsItem>)
        fun helloCleanArchText(str: String)

    }

    interface Presenter{
        fun getNews()
        fun setTexttoView(str : String)
        fun getRecyclerItemListener() : RecyclerItemListener

    }
}