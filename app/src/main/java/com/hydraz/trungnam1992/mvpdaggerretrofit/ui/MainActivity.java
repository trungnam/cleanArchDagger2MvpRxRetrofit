package com.hydraz.trungnam1992.mvpdaggerretrofit.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.hydraz.trungnam1992.mvpdaggerretrofit.App;
import com.hydraz.trungnam1992.mvpdaggerretrofit.R;
import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.datatobject.NewsItem;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContact.MainView {

    @Inject
    MainPresenter mainPresenter;
    RecyclerView recyclerView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initializeDagger() {
        App app  = (App)getApplicationContext();
        app.getAppComponent().inject(MainActivity.this);
    }

    @Override
    protected void initializePresenter() {
        mainPresenter.attachView(this);
        mainPresenter.setTexttoView("Hello");
        mainPresenter.getNews();
    }

    @Override
    public void initializeNewsList(List<? extends NewsItem> news) {
        recyclerView = (RecyclerView)findViewById(R.id.new_recycleview);
        NewsAdapter newsAdapter = new NewsAdapter(mainPresenter.getRecyclerItemListener(), news);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(newsAdapter);
    }

    @Override
    public void helloCleanArchText(String str) {
        TextView textView = (TextView)findViewById(R.id.texthello);
        textView.setText( " " + str);
    }
}
