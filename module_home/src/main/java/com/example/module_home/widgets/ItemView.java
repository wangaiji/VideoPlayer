package com.example.module_home.widgets;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.module_home.R;
import com.example.module_home.adapter.VideoRecommendAdapter;
import com.example.module_home.data.VideoRecommend;
import com.example.module_home.mvp.contract.MessageContract;
import com.example.module_home.mvp.presenter.MessagePresenter;

import java.util.ArrayList;
import java.util.List;

public class ItemView extends LinearLayout implements MessageContract.View {
    private TextView itemName;
    private RecyclerView recyclerView;
    private VideoRecommendAdapter adapter;
    private GridLayoutManager layoutManager;
    private MessagePresenter messagePresenter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String name;
    private String id;
    private List<VideoRecommend> videoRecommendList = new ArrayList<>();

    public ItemView(Context context) {
        this(context, null);
    }

    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ItemView init(String id) {
        this.id = id;
        LayoutInflater.from(getContext()).inflate(R.layout.h_recommend_item, this, true);
        itemName = findViewById(R.id.item_name);
        recyclerView = findViewById(R.id.home_recycler_view);
        messagePresenter = new MessagePresenter(getContext(),this);
        messagePresenter.getVideoMessage(id);
        layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        // 解决滑动冲突
        recyclerView.setNestedScrollingEnabled(false);
        adapter = new VideoRecommendAdapter(videoRecommendList);
        recyclerView.setAdapter(adapter);
        return this;
    }

    public void refresh() {
        messagePresenter.getVideoMessage(id);
    }

    public void BottomRefresh() {
        messagePresenter.getVideoMessage(id);
    }

    public ItemView setItemName(String name) {
        itemName.setText(name);
        this.name = name;
        return this;
    }


    public ItemView setSwipeLayout(SwipeRefreshLayout swipeLayout) {
        swipeRefreshLayout = swipeLayout;
        return this;
    }



    @Override
    public void refreshData(List<VideoRecommend> videoRecommends) {
            Log.d("2748764",adapter.getItemCount()+"  1");
            adapter.addData(adapter.getItemCount(), videoRecommends);
    }

    @Override
    public void setData(List<VideoRecommend> videoRecommends) {
        adapter.setVideoRecommendList(videoRecommends);
        adapter.notifyDataSetChanged();
    }

    @Override
    public String getDataName() {
        return name;
    }

    @Override
    public void stopRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }


    public void destroy() {
        messagePresenter.detachView();
    }
}
