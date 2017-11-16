package com.hydraz.trungnam1992.mvpdaggerretrofit.ui.contact

import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.BaseView

/**
 * Created by trungnam1992 on 11/16/17.
 */
public interface LoginSignupContact{

    interface LoginSignupView : BaseView{


    }

    interface Presenter{
        fun LoginNormal(email : String, password : String)

        fun Logout()
        fun LoginFb()
        fun LoinGoogle()

    }

}