package com.hydraz.trungnam1992.mvpdaggerretrofit.ui.view

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.hydraz.trungnam1992.mvpdaggerretrofit.App
import com.hydraz.trungnam1992.mvpdaggerretrofit.R
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.contact.LoginSignupContact
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.presenter.LoginSignupPresenter
import javax.inject.Inject

class LoginSignUpActivity : BaseActivity(), LoginSignupContact.LoginSignupView {
    @Inject lateinit var loginSignupPresenter: LoginSignupPresenter


    private lateinit var editTextEmail: EditText
    private lateinit var editTestPassword: EditText

    override val layoutId: Int
        get() = R.layout.activity_login_sign_in

    override fun initializeDagger() {
        val app = applicationContext as App
        app.getAppComponent().inject(this)

    }

    override fun initializePresenter() {
        loginSignupPresenter.attachView(this)
        editTestPassword = findViewById(R.id.ed_password) as EditText
        editTextEmail = findViewById(R.id.ed_username) as EditText

        editTextEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) = Unit
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int)
                    = loginSignupPresenter.validateEmail(p0.toString())
        })
    }

    override fun showEmailError(error: String) = editTextEmail.setError(error, null)
    override fun onDestroy() {
        super.onDestroy()
        loginSignupPresenter.detachView(this)
    }
}
