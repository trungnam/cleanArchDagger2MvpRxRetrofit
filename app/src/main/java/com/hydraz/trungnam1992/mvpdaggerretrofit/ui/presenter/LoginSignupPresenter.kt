package com.hydraz.trungnam1992.mvpdaggerretrofit.ui.presenter

import android.os.Bundle
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.contact.LoginSignupContact
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

/**
 * Created by trungnam1992 on 11/19/17.
 */
class LoginSignupPresenter @Inject constructor() : BasePresenter<LoginSignupContact.LoginSignupView>(), LoginSignupContact.Presenter{

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