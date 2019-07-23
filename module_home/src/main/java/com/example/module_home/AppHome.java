package com.example.module_home;

import android.app.Application;
import android.util.Log;

public class AppHome extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("oncreate", "AppHome");
    }
}
