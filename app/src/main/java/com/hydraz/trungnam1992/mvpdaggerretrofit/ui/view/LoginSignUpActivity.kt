package com.hydraz.trungnam1992.mvpdaggerretrofit.ui.view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import com.hydraz.trungnam1992.mvpdaggerretrofit.App
import com.hydraz.trungnam1992.mvpdaggerretrofit.R
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.contact.LoginSignupContact
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.presenter.LoginSignupPresenter
import javax.inject.Inject


class LoginSignUpActivity : BaseActivity(), LoginSignupContact.LoginSignupView {

    @Inject lateinit var loginSignupPresenter: LoginSignupPresenter

    private lateinit var editTextEmail: EditText
    private lateinit var btnLogin: Button

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
        btnLogin = findViewById(R.id.btn_login) as Button

        editTextEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) = Unit
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int)
                    = loginSignupPresenter.validateEmail(email = p0.toString())
        })
        editTestPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int)
                    = loginSignupPresenter.validatePassword(password = p0.toString())

        })
        btnLogin.setOnClickListener({
            loginSignupPresenter.loginNormal(editTextEmail.text.toString(), editTestPassword.text.toString())
        })
    }

    override fun showEmailError(error: String?) {
        editTextEmail.run {
            setError(error, null)
            requestFocus()
        }
    }

    override fun showPasswordError(error: String?) {
        editTestPassword.run {
            setError(error, null)
            requestFocus()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        loginSignupPresenter.detachView(this)
    }

    override fun requestFocusEmail(s: String?) {
        editTextEmail.requestFocus()
        when {
            editTextEmail.error == null -> editTextEmail.setError(s, null)
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editTextEmail, InputMethodManager.SHOW_IMPLICIT)
    }

    override fun requestFocusPass(s: String?) {
        editTestPassword.requestFocus()
        editTestPassword.setError(s, null)
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editTestPassword, InputMethodManager.SHOW_IMPLICIT)
    }
}
