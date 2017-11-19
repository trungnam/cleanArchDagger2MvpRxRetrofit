package com.hydraz.trungnam1992.mvpdaggerretrofit.ui.contact

import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.presenter.BaseView

/**
 * Created by trungnam1992 on 11/16/17.
 */
public interface LoginSignupContact{

    interface LoginSignupView : BaseView {


    }

    interface Presenter{
        fun loginNormal(email : String, password : String)
        fun logout()
        fun loginFb()
        fun loinGoogle()
        fun validatEmailPass(email: String, password: String)
    }

}