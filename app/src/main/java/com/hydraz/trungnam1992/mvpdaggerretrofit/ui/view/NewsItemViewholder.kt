package com.hydraz.trungnam1992.mvpdaggerretrofit.ui.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.hydraz.trungnam1992.mvpdaggerretrofit.App
import com.hydraz.trungnam1992.mvpdaggerretrofit.R
import com.hydraz.trungnam1992.mvpdaggerretrofit.data.repo.remote.datatobject.NewsItem
import com.hydraz.trungnam1992.mvpdaggerretrofit.ui.Listener.RecyclerItemListener
import com.hydraz.trungnam1992.mvpdaggerretrofit.utils.ObjectUtil.isEmpty
import com.hydraz.trungnam1992.mvpdaggerretrofit.utils.ObjectUtil.isNull
import com.hydraz.trungnam1992.mvpdaggerretrofit.utils.ResourcesUtil.getDrawableById
import com.squareup.picasso.Picasso

/**
 * Created by trungnam1992 on 11/6/17.
 */
class NewsViewHolder(itemView: View, private val onItemClickListener: RecyclerItemListener) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.tv_caption)
    internal var tvCaption: TextView? = null
    @BindView(R.id.tv_title)
    internal var tvTitle: TextView? = null
    internal var newsItemLayout: RelativeLayout? = null


    private var newsImage: ImageView

    init {
        ButterKnife.bind(this, itemView)
        newsImage = itemView.findViewById(R.id.iv_news_item_image) as ImageView
        newsItemLayout = itemView.findViewById(R.id.rl_news_item) as RelativeLayout
    }

    fun bind(position: Int, newsItem: NewsItem, recyclerItemListener: RecyclerItemListener) {
        //need to move to mapper
        if (!isEmpty(newsItem.getAbstract())) {
            tvTitle?.setText(newsItem.getTitle())
        }
        if (!isEmpty(newsItem.getTitle())) {
            tvCaption?.setText(newsItem.getAbstract())
        }
        var URL: String? = null


        if (!isNull(newsItem.getMultimedia()) && newsItem.getMultimedia().size > 3) {
            URL = newsItem.getMultimedia().get(3).getUrl()
        }
        Picasso.with(App.getContext()).load(URL).placeholder(getDrawableById(R.drawable.avata)).into(newsImage)
        newsItemLayout?.setOnClickListener { v -> recyclerItemListener.onItemSelected(position) }
    }
}
