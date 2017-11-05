package com.hydraz.trungnam1992.mvpdaggerretrofit.di

import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by trungnam1992 on 11/1/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
public interface AppComponent{

    fun inject(activity: MainActivity)

}