package com.example.module_home.util;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static ApiService mApiService;

    public static ApiService getApiService() {
        if (mApiService == null) {
            synchronized (RetrofitUtils.class) {
                if (mApiService == null) {
                    mApiService = new RetrofitUtils().initApiService();
                }
            }
        }
        return mApiService;
    }

    private ApiService initApiService() {
        return initRetrofit().create(ApiService.class);
    }

    private Retrofit initRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ApiService.API_SERVER_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(okHttpClient)
                        .build();
        return retrofit;
    }
}
