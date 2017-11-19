package com.hydraz.trungnam1992.mvpdaggerretrofit.di

import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.view.MainActivity
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.view.LoginSignUpActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by trungnam1992 on 11/1/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
public interface AppComponent{

    fun inject(activity: MainActivity)
    fun inject(loiginSignUpActivity: LoginSignUpActivity)

}