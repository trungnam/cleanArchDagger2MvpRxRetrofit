package com.hydraz.trungnam1992.mvpdaggerretrofit.data;


import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.datatobject.NewsModel;

import io.reactivex.Single;

/**
 * Created by ahmedeltaher on 3/23/17.
 */

interface DataSource {
    Single<NewsModel> requestNews();
}
