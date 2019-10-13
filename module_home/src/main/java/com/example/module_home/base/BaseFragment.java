package com.example.module_home.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

public abstract class BaseFragment extends Fragment {
    private boolean isPrepareView = false;
    private boolean isInitData = false;
    private boolean isVisibleToUser = false;
    private boolean isFirstTime = true;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d("3877645","4");
        super.onViewCreated(view, savedInstanceState);
        isPrepareView = true;
    }

    private void lazyInitData() {
        if (!isInitData && isPrepareView && isVisibleToUser && isFirstTime) {
            initData();
            isInitData = true;
            isFirstTime = false;
        }
    }


    /**
     * fragment生命周期中onViewCreated之后的方法
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("3877645","3");
        super.onActivityCreated(savedInstanceState);
        lazyInitData();
    }

    /**
     * 可见和不可见的切换,，可能在onCreateView之前调用
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        lazyInitData();
    }

    public abstract void initData();
}
