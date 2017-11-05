package com.hydraz.trungnam1992.mvpdaggerretrofit.di

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by trungnam1992 on 11/1/17.
 */
@Module
public class AppModule(){

    lateinit var mApplication : Application

    fun AppModule(mApplication: Application) {
        this.mApplication = mApplication
    }

    @Provides
    @Singleton
    internal fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    @Singleton
    fun providerGson(): Gson {
        val gson  = GsonBuilder().create()
        return gson
    }
    @Provides
    @Singleton
    fun providerCompositeDisposable(): CompositeDisposable {
        val compositeDisposable = CompositeDisposable()
        return compositeDisposable
    }

}