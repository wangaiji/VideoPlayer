package com.example.module_community.module;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

public class AppCommunity extends Application {
    private boolean isDebugARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("oncreate", "AppCommunity");
    }
}
