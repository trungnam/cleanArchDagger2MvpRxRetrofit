package com.hydraz.trungnam1992.mvpdaggerretrofit.ui

import android.os.Bundle
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by trungnam1992 on 11/3/17.
 */
public  interface BasePresenter< in T : BaseView> {


    var isViewAlive : AtomicBoolean

    fun detachView(view: T)
    fun attachView(view: T)

    fun initialize (extras: Bundle)

    fun start() = this.isViewAlive.set(true)

    fun finalizeView() = isViewAlive.set(false)
}
