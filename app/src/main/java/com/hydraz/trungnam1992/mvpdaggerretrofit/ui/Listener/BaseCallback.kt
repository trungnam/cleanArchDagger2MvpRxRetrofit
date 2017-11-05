package com.hydraz.trungnam1992.mvpdaggerretrofit.ui.Listener

import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.datatobject.NewsModel

/**
 * Created by trungnam1992 on 11/5/17.
 */
interface BaseCallback {

    fun onSuccess(newsModel: NewsModel)

    fun onFail()
}
