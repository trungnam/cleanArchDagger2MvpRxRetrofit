package com.hydraz.trungnam1992.mvpdaggerretrofit.ui.presenter

import android.os.Bundle
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by trungnam1992 on 11/3/17.
 */
abstract class BasePresenter< in T : BaseView> {


    open lateinit var isViewAlive : AtomicBoolean

    abstract fun detachView(view: T)
    abstract fun attachView(view: T)

    open fun initialize (extras: Bundle) {}

    fun start() = this.isViewAlive.set(true)

    fun finalizeView() = isViewAlive.set(false)
}
