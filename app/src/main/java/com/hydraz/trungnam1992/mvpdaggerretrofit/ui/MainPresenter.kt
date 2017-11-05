package com.hydraz.trungnam1992.mvpdaggerretrofit.ui

import android.os.Bundle
import android.util.Log
import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.datatobject.NewsModel
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.Listener.BaseCallback
import com.hydraz.trungnam1992.mvpdaggerretrofit.usecase.GetNewItemUseCase
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

/**
 * Created by trungnam1992 on 11/4/17.
 */
class MainPresenter
    @Inject
    constructor( var newItemUseCase: GetNewItemUseCase ) : BasePresenter<MainContact.MainView>, MainContact.Presenter {
    override fun initialize(extras: Bundle) {

    }

    override var isViewAlive: AtomicBoolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}


    private lateinit var view: MainContact.MainView
    override fun detachView(view: MainContact.MainView) {
    }

    override fun attachView(view: MainContact.MainView) {
        this.view = view
    }

    override fun getNews() {

        newItemUseCase.getNews(callback)


    }
    val callback = object : BaseCallback{
        override fun onSuccess(newsModel: NewsModel) {

            Log.e("nnam " , "onSuccess" + newsModel.toString() )

        }

        override fun onFail() {
            Log.e("nnam " , "onFail"  )

        }

    }
    override fun setTexttoView(str: String) {
        view.helloCleanArchText(str)
    }

}
