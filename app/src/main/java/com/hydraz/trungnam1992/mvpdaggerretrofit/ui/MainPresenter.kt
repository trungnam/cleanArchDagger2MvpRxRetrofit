package com.hydraz.trungnam1992.mvpdaggerretrofit.ui

import android.os.Bundle
import android.util.Log
import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.datatobject.NewsModel
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.Listener.BaseCallback
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.Listener.RecyclerItemListener
import com.hydraz.trungnam1992.mvpdaggerretrofit.usecase.GetNewItemUseCase
import com.hydraz.trungnam1992.mvpdaggerretrofit.utils.AppLog
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject




/**
 * Created by trungnam1992 on 11/4/17.
 */
class MainPresenter
    @Inject
    constructor( var newItemUseCase: GetNewItemUseCase ) : BasePresenter<MainContact.MainView>(), MainContact.Presenter {


    private val recyclerItemListener = object : RecyclerItemListener {
        override fun onItemSelected(position: Int) {
            Observable
                    .just("rain water", "river water", "lake water")
                    .map { water -> "Clean $water" }
                    .subscribe{ cleanWater -> Log.i("TAG", "Drink $cleanWater") }


            var com = CompositeDisposable()

            val obser = Observable.just(1,2,3,4,6,7,8)
                    .reduce { t1: Int, t2: Int ->
                      var t =  t1+ t2
                        t
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.newThread())
                    .subscribe{
                        t: Int ->  AppLog.e("","num $t")
                        Log.i("TAG", "num $t")
                    }
            var myObservable = Observable.create(
                    object : ObservableOnSubscribe<Int>{
                        override fun subscribe(e: ObservableEmitter<Int>?) {
                            e?.onNext(10000000)
                        }

                    }
            )

            myObservable.subscribeOn(Schedulers.computation()).subscribeOn(Schedulers.newThread())
                    .subscribe({ t: Int ->
                        AppLog.e("" , "nnam  $t")

                    })
        }
    }

    override fun getRecyclerItemListener(): RecyclerItemListener = recyclerItemListener


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

            AppLog.v("nnam " , "onSuccess" + newsModel.toString() )
            view.initializeNewsList(newsModel.newsItems)

        }

        override fun onFail() {
            Log.e("nnam " , "onFail"  )

        }

    }
    override fun setTexttoView(str: String) {
        view.helloCleanArchText(str)
    }

}
