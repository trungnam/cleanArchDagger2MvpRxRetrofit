package com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote;

import io.reactivex.Single;

/**
 * Created by ahmedeltaher on 3/23/17.
 */

interface RemoteSource {
    Single getNews();
}
