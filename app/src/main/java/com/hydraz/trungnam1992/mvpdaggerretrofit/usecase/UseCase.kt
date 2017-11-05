package com.hydraz.trungnam1992.mvpdaggerretrofit.usecase

import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.Listener.BaseCallback

/**
 * Created by trungnam1992 on 11/5/17.
 */
public interface UseCase{

    fun getNews(callback: BaseCallback)

}