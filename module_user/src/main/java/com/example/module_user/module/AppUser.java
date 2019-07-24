package com.example.module_user.module;

import android.app.Application;
import android.util.Log;

public class AppUser extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("oncreate", "AppUser");
    }
}
