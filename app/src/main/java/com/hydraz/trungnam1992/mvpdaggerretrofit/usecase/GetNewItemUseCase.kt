package com.hydraz.trungnam1992.mvpdaggerretrofit.usecase

import com.hydraz.trungnam1992.mvpdaggerretrofit.data.DataRepository
import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.datatobject.NewsModel
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.Listener.BaseCallback
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by trungnam1992 on 11/5/17.
 */
class GetNewItemUseCase @Inject constructor(
              var dataResponsitory : DataRepository,
              var  compositeDisposable: CompositeDisposable
                ): UseCase {


    lateinit var disposableSingleObserver:  DisposableSingleObserver<NewsModel>

    lateinit var singleNewItems : Single<NewsModel>

    private lateinit var newsDisposable: Disposable


    override fun getNews(callback: BaseCallback) {

        disposableSingleObserver = object : DisposableSingleObserver<NewsModel>() {
            override fun onSuccess(newsModel: NewsModel) {
                callback.onSuccess(newsModel)
            }

            override fun onError(e: Throwable) {
                callback.onFail()
            }
        }
        if(!compositeDisposable.isDisposed){
            singleNewItems = dataResponsitory.requestNews()

            newsDisposable =singleNewItems.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribeWith(disposableSingleObserver)
            compositeDisposable.add(newsDisposable)

        }
    }

    fun unSubscribe() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.remove(newsDisposable)
        }
    }

}