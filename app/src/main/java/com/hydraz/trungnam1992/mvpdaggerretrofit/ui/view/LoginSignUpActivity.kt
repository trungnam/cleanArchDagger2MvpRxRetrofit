package com.hydraz.trungnam1992.mvpdaggerretrofit.ui.view

import android.widget.EditText
import com.hydraz.trungnam1992.mvpdaggerretrofit.App
import com.hydraz.trungnam1992.mvpdaggerretrofit.R
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.contact.LoginSignupContact
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.presenter.LoginSignupPresenter
import javax.inject.Inject

class LoginSignUpActivity : BaseActivity() , LoginSignupContact.LoginSignupView {
    @Inject lateinit var loginSignupPresenter : LoginSignupPresenter


    private lateinit var editTextEmail : EditText
    private lateinit var editTestUsername : EditText



    override val layoutId: Int
        get() = R.layout.activity_login_sign_in

    override fun initializeDagger() {
        val app = applicationContext as App
        app.getAppComponent().inject(this)

    }

    override fun initializePresenter() {
        loginSignupPresenter.attachView(this)

    }

    override fun onDestroy() {
        super.onDestroy()
        loginSignupPresenter.detachView(this)
    }
}
