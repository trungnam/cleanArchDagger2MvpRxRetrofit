package com.hydraz.trungnam1992.mvpdaggerretrofit.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hydraz.trungnam1992.mvpdaggerretrofit.R;
import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.datatobject.NewsItem;
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.Listener.RecyclerItemListener;
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.view.NewsViewHolder;

import java.util.List;

/**
 * Created by trungnam1992 on 11/6/17.
 */


public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private final List<NewsItem> news;
    private RecyclerItemListener onItemClickListener;

    public NewsAdapter(RecyclerItemListener onItemClickListener, List<? extends NewsItem> news) {
        this.onItemClickListener = onItemClickListener;
        this.news = (List<NewsItem>) news;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.bind(position, news.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }
}

