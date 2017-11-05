package com.hydraz.trungnam1992.mvpdaggerretrofit.data;


import com.hydraz.trungnam1992.mvpdaggerretrofit.data.local.LocalRepository;
import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.RemoteRepository;
import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.datatobject.NewsModel;

import javax.inject.Inject;

import io.reactivex.Single;


/**
 * Created by AhmedEltaher on 5/12/2016
 */

public class DataRepository implements DataSource {
    private RemoteRepository remoteRepository;
    private LocalRepository localRepository;

    @Inject
    public DataRepository(RemoteRepository remoteRepository, LocalRepository localRepository) {
        this.remoteRepository = remoteRepository;
        this.localRepository = localRepository;
    }

    @Override
    public Single<NewsModel> requestNews() {
        return remoteRepository.getNews();
    }
}
