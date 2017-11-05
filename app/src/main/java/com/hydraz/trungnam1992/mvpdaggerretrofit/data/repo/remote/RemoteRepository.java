package com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.hydraz.trungnam1992.mvpdaggerretrofit.App;
import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.datatobject.NewsModel;
import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.service.NewsService;
import com.hydraz.trungnam1992.mvpdaggerretrofit.utils.Constants;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;

import static com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.ServiceError.NETWORK_ERROR;
import static com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.ServiceError.SUCCESS_CODE;
import static com.hydraz.trungnam1992.mvpdaggerretrofit.utils.Constants.ERROR_UNDEFINED;
import static com.hydraz.trungnam1992.mvpdaggerretrofit.utils.NetworkUtils.isConnected;
import static com.hydraz.trungnam1992.mvpdaggerretrofit.utils.ObjectUtil.isNull;


/**
 * Created by AhmedEltaher on 5/12/2016
 */

public class RemoteRepository implements RemoteSource {
    private ServiceGenerator serviceGenerator;
    private final String UNDELIVERABLE_EXCEPTION_TAG = "Undeliverable exception received, not sure what to do";

    @Inject
    public RemoteRepository(ServiceGenerator serviceGenerator) {
        this.serviceGenerator = serviceGenerator;
    }

    @Override
    public Single getNews() {


        RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
            @SuppressLint("LongLogTag")
            @Override
            public void accept(@io.reactivex.annotations.NonNull Throwable throwable) throws Exception {
                Log.i(UNDELIVERABLE_EXCEPTION_TAG, throwable.getMessage());
            return;
            }
        });

        Single<NewsModel> newsModelSingle = Single.create(new SingleOnSubscribe<NewsModel>() {
            @Override
            public void subscribe(SingleEmitter<NewsModel> e) throws Exception {
                                    if (!isConnected(App.getContext())) {
                        Exception exception = new NetworkErrorException();
                        e.onError(exception);
                    } else {
                        try {
                            NewsService newsService = serviceGenerator.createService(NewsService.class, Constants.BASE_URL);
                            ServiceResponse serviceResponse = processCall(newsService.fetchNews(), false);
                            if (serviceResponse.getCode() == SUCCESS_CODE) {
                                NewsModel newsModel = (NewsModel) serviceResponse.getData();
                                e.onSuccess(newsModel);
                            } else {
                                Throwable throwable = new NetworkErrorException();
                                e.onError(throwable);
                            }
                        } catch (Exception ex) {
                            e.onError(ex);
                        }
                    }

            }
        });

        return newsModelSingle;
    }

    @NonNull
    private ServiceResponse processCall(Call call, boolean isVoid) {
        if (!isConnected(App.getContext())) {
            return new ServiceResponse(new ServiceError());
        }
        try {
            retrofit2.Response response = call.execute();
            Gson gson = new Gson();
//            L.json(NewsModel.class.getName(), gson.toJson(response.body()));
            Log.e("nnam", gson.toJson(response.body()));
            if (isNull(response)) {
                Log.e("nnam", "NETWORK_ERROR");

                return new ServiceResponse(new ServiceError(NETWORK_ERROR, ERROR_UNDEFINED));
            }
            int responseCode = response.code();
            if (response.isSuccessful()) {
                return new ServiceResponse(responseCode, isVoid ? null : response.body());
            } else {
                ServiceError ServiceError;
                ServiceError = new ServiceError(response.message(), responseCode);
                return new ServiceResponse(ServiceError);
            }
        } catch (IOException e) {
            return new ServiceResponse(new ServiceError(NETWORK_ERROR, ERROR_UNDEFINED));
        }
    }
}
