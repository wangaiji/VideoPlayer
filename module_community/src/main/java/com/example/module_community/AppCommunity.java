package com.example.module_community;

import android.app.Application;
import android.util.Log;

public class AppCommunity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("oncreate", "AppCommunity");
    }
}