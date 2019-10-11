package com.example.module_home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.module_home.BuildConfig;
import com.example.module_home.R;
import com.example.module_home.adapter.FragmentAdapter;
import com.example.module_home.widgets.BannerLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/home/fragment")
public class HomeFragment extends Fragment {
    private Banner banner;
    private ArrayList<String> imagePathList;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.h_fragment_home, container, false);
        tabLayout = view.findViewById(R.id.home_tabs);
        viewPager = view.findViewById(R.id.home_viewpager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViewPager();
        Log.d("284366","1");
    }

    private void initViewPager() {
        List<String> titles = new ArrayList<>();
        titles.add("新知");
        titles.add("社会");
        titles.add("世界");
        titles.add("体育");
        titles.add("生活");
        titles.add("科技");
        titles.add("娱乐");
        titles.add("财富");

        for(int i = 0; i < titles.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(titles.get(i)));
        }

        List<Fragment> fragmentList = new ArrayList<>();
        for(int i = 0; i < titles.size(); i++) {
            fragmentList.add(new RecommendFragment());
        }

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager(), fragmentList, titles);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }



}
