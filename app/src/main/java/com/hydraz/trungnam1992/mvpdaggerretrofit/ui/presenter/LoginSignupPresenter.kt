package com.hydraz.trungnam1992.mvpdaggerretrofit.ui.presenter

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.contact.LoginSignupContact
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

/**
 * Created by trungnam1992 on 11/19/17.
 */
class LoginSignupPresenter @Inject constructor() : BasePresenter<LoginSignupContact.LoginSignupView>(),
        LoginSignupContact.Presenter {


    override fun validateEmail(email: String?) {

        Single.just(email)
                .delay(700, TimeUnit.MILLISECONDS)
                .map {
                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() && !TextUtils.isEmpty(it)) {
                        var ex = Exception("not vailid")
                        throw ex
                    }

                    return@map TextUtils.isEmpty(it)

                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : SingleObserver<Boolean> {
                    override fun onError(e: Throwable?) {
                        view.showEmailError("Email not vailid !")
                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                    override fun onSuccess(t: Boolean) {
                        if (t) {
                            view.showEmailError("Email can't empty!")

                        }
                    }

                })

    }


    private lateinit var view: LoginSignupContact.LoginSignupView


    override lateinit var isViewAlive: AtomicBoolean


    override fun initialize(extras: Bundle) {
    }

    override fun detachView(view: LoginSignupContact.LoginSignupView) {
        this.view = view
    }

    override fun attachView(view: LoginSignupContact.LoginSignupView) {
        this.view = view
    }

    override fun loginNormal(email: String, password: String) {

    }

    override fun logout() {

    }

    override fun loginFb() {

    }

    override fun loinGoogle() {

    }

    override fun validatEmailPass(email: String, password: String) {

    }

}