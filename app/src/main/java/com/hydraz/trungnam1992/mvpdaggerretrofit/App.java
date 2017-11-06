package com.hydraz.trungnam1992.mvpdaggerretrofit;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.hydraz.trungnam1992.mvpdaggerretrofit.di.AppComponent;
import com.hydraz.trungnam1992.mvpdaggerretrofit.di.DaggerAppComponent;

/**
 * Created by trungnam1992 on 11/1/17.
 */

public class App extends MultiDexApplication{

    static Context context;

    public static Context getContext() {
        return context;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context= this;
        appComponent = DaggerAppComponent.create();
    }

    public App() {
        super();
    }
}


