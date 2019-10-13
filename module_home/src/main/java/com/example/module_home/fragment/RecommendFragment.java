package com.example.module_home.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.module_home.R;
import com.example.module_home.base.BaseFragment;
import com.example.module_home.mvp.presenter.MessagePresenter;
import com.example.module_home.widgets.BannerLoader;
import com.example.module_home.widgets.ItemView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class RecommendFragment extends BaseFragment implements OnBannerListener, SwipeRefreshLayout.OnRefreshListener, NestedScrollView.OnScrollChangeListener{
    private Banner banner;
    private List<String> imagePathList;
    private LinearLayout mItemLayout;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<MessagePresenter> messagePresenter = new ArrayList<>();
    private NestedScrollView scrollView;
    private ItemView oneView;
    private ItemView twoView;
    private ItemView threeView;
    private Bundle bundle;
    private Boolean IsFirstTime = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("3877645","2");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.h_fragment_recommend, container, false);
        banner = view.findViewById(R.id.rf_banner);
        mItemLayout = view.findViewById(R.id.h_recommend_layout);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        scrollView = view.findViewById(R.id.scrollView);
        swipeRefreshLayout.setOnRefreshListener(this);
        scrollView.setOnScrollChangeListener(this);
        return view;
    }

    @Override
    public void initData() {
        imagePathList = new ArrayList<>();
        imagePathList.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        imagePathList.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        imagePathList.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
        imagePathList.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");
        banner.setImageLoader(new BannerLoader());
        banner.setImages(imagePathList);
        banner.setBannerAnimation(Transformer.Default);
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        banner.setOnBannerListener(this)
                .start();
        bundle = getArguments();
        final String data = bundle.getString("id");
        oneView = new ItemView(getContext())
                .init(data)
                .setItemName("最热")
                .setSwipeLayout(swipeRefreshLayout);
        messagePresenter.add((MessagePresenter) oneView.getPresenter());
        twoView = new ItemView(getContext())
                .init(data)
                .setItemName("最新")
                .setSwipeLayout(swipeRefreshLayout);
        messagePresenter.add((MessagePresenter) twoView.getPresenter());
        threeView = new ItemView(getContext())
                .init(data)
                .setItemName("热门")
                .setSwipeLayout(swipeRefreshLayout);
        messagePresenter.add((MessagePresenter) threeView.getPresenter());
        mItemLayout.addView(oneView);
        mItemLayout.addView(twoView);
        mItemLayout.addView(threeView);

    }

    @Override
    public void OnBannerClick(int position) {

    }

    @Override
    public void onRefresh() {
        oneView.refresh();
        twoView.refresh();
        threeView.refresh();
    }

    @Override
    public void onDestroy() {
        if (messagePresenter != null) {
            for (MessagePresenter messagePresenter: messagePresenter) {
                messagePresenter.detachView();
            }
            messagePresenter = null;
        }
        Log.d("3877645","1");
        super.onDestroy();
    }

    @Override
    public void onScrollChange(NestedScrollView nestedScrollView, int x, int y, int oldX, int oldY) {
        if (y == (nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight())) {
            Log.d("6543433", "1");
            threeView.BottomRefresh();
        }
    }
}
