package com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote;

import com.hydraz.trungnam1992.mvpdaggerretrofit.utils.AppLog;

/**
 * Created by AhmedEltaher on 5/12/2016
 */

public class ServiceError {
    public static final String NETWORK_ERROR = "Unknown ServiceError";
    private static final int GROUP_200 = 2;
    private static final int GROUP_400 = 4;
    private static final int GROUP_500 = 5;
    private static final int VALUE_100 = 100;
    public static final int SUCCESS_CODE = 200;
    public static final int ERROR_CODE = 400;
    private String description;
    private int code;

    public static boolean isSuccess(int responseCode) {
        return responseCode / VALUE_100 == GROUP_200;
    }

    public static boolean isClientError(int errorCode) {
        return errorCode / VALUE_100 == GROUP_400;
    }

    public static boolean isServerError(int errorCode) {
        return errorCode / VALUE_100 == GROUP_500;
    }

    public ServiceError() {
        AppLog.e("" , "Service error");
    }

    public ServiceError(String description, int code) {
        this.description = description;
        this.code = code;
        AppLog.e("" , "Service error " + description );
        AppLog.e("" , "Service error " + code );


    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }
}
