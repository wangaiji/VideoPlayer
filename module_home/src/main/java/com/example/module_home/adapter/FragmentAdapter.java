package com.example.module_home.adapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.module_home.fragment.RecommendFragment;

import java.util.List;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mTitles;

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        mFragments = fragments;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int i) {
        RecommendFragment fragment = new RecommendFragment();
        Bundle bundle = new Bundle();
        if (mTitles.get(i).equals("新知")) {
            bundle.putString("id", "10");
        }else if (mTitles.get(i).equals("社会")) {
            bundle.putString("id", "1");
        }else if (mTitles.get(i).equals("世界")) {
            bundle.putString("id", "2");
        }else if (mTitles.get(i).equals("体育")) {
            bundle.putString("id", "9");
        }else if (mTitles.get(i).equals("生活")) {
            bundle.putString("id", "5");
        }else if (mTitles.get(i).equals("科技")) {
            bundle.putString("id", "8");
        }else if (mTitles.get(i).equals("娱乐")) {
            bundle.putString("id", "4");
        }else if (mTitles.get(i).equals("财富")) {
            bundle.putString("id", "3");
        }
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // super.destroyItem(container, position, object);
    }
}
