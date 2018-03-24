package com.hydraz.trungnam1992.mvpdaggerretrofit.ui.presenter

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.contact.LoginSignupContact
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

/**
 * Created by trungnam1992 on 11/19/17.
 */
class LoginSignupPresenter @Inject constructor() : BasePresenter<LoginSignupContact.LoginSignupView>(),
        LoginSignupContact.Presenter {

    override var isEmailOk: Boolean = false

    override var isPassOk: Boolean = false


    override fun validateEmail(email: String?) {

        PublishSubject.just(email)
                .delay(300, TimeUnit.MILLISECONDS)
                .map {
                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() && !TextUtils.isEmpty(it)) {
                        var ex = Exception("not vailid")
                        throw ex
                    }
                    return@map TextUtils.isEmpty(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : Observer<Boolean> {
                    override fun onSubscribe(d: Disposable?) {

                    }

                    override fun onComplete() {
                    }

                    override fun onError(e: Throwable?) {
                        view.showEmailError("Email not vailid !")
                        isEmailOk = false
                    }

                    override fun onNext(t: Boolean?) = if (t!!) {
                        view.showEmailError("Email can't empty!")
                        isEmailOk = false

                    } else {
                        view.showEmailError(null)
                        isEmailOk = true
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

    override fun loginNormal(email: String?, password: String?) {

        when {
            !isEmailOk -> {
                view.requestFocusEmail("Please input your email!")
                return
            }
            !isPassOk -> {
                view.requestFocusPass("Please input your password!")
                return
            }
            isEmailOk && isPassOk -> {
                //TODO
            }
        }


    }

    override fun logout() {

    }

    override fun loginFb() {

    }

    override fun loinGoogle() {

    }

    override fun validatEmailPass(email: String, password: String) {

    }

    override fun validatePassword(password: String?) {
        PublishSubject.just(password)
                .debounce(200, TimeUnit.MILLISECONDS)
                .map {
                    if (TextUtils.isEmpty(password)) {
                        throw Exception()
                    }
                    return@map true
                }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : Observer<Boolean> {
                    override fun onNext(t: Boolean?) {
                        isPassOk = true
                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                    override fun onComplete() {
                    }

                    override fun onError(e: Throwable?) {
                        view.showPasswordError("Password can't not empty!")
                        isPassOk = false
                    }

                })
    }

}
