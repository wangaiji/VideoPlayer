package com.example.module_home.module;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

public class AppHome extends Application {
    private boolean isDebugARouter = true;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("oncreate", "AppHome");
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
