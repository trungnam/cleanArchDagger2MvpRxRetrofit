package com.hydraz.trungnam1992.mvpdaggerretrofit.ui.contact

import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.presenter.BaseView

/**
 * Created by trungnam1992 on 11/16/17.
 */
public interface LoginSignupContact {

    interface LoginSignupView : BaseView {

        fun showEmailError(error: String?)
        fun showPasswordError(error: String?)
        fun requestFocusEmail(error: String?)
        fun requestFocusPass(error: String?)

    }

    interface Presenter {
        var isEmailOk: Boolean
        val isPassOk: Boolean

        fun loginNormal(email: String?, password: String?)
        fun logout()
        fun loginFb()
        fun loinGoogle()
        fun validateEmail(email: String?)
        fun validatePassword(password: String?)
        fun validatEmailPass(email: String, password: String)
    }

}