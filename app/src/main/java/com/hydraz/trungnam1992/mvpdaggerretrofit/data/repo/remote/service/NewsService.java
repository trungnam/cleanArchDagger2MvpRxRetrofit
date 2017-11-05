package com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.service;

import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.datatobject.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by AhmedEltaher on 5/12/2016
 */

public interface NewsService {
    @GET("topstories/v2/home.json")
    Call<NewsModel> fetchNews();
}
