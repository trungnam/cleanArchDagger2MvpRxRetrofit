package com.hydraz.trungnam1992.mvpdaggerretrofit.utils;


import com.hydraz.trungnam1992.mvpdaggerretrofit.BuildConfig;
import com.orhanobut.logger.Logger;

/**
 * Created by AhmedEltaher on 01/01/17.
 */

public class AppLog {
    public static void d(String tag, String massage) {
        if (BuildConfig.DEBUG) {
            Logger.d(tag, massage);
        }
    }

    public static void i(String tag, String massage) {
        if (BuildConfig.DEBUG) {
            Logger.i(tag, massage);
        }
    }

    public static void v(String tag, String massage) {
        if (BuildConfig.DEBUG) {
            Logger.v(tag, massage);
        }
    }

    public static void e(String tag, String massage) {
        if (BuildConfig.DEBUG) {
            Logger.e(tag, massage);
        }
    }

    public static void json(String tag, String massage) {
        if (BuildConfig.DEBUG) {
            Logger.i(tag);
            Logger.json(massage);
        }
    }
}
