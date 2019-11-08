package com.example.module_home.util;


import android.util.Log;

import com.example.module_home.module.AppHome;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                            .cache(new Cache(new File(AppHome.getContext().getExternalCacheDir(), "test_cache"), 10*1024*1024))
                            .addInterceptor(new CacheInterceptor())
                            .addNetworkInterceptor(new CacheNetworkInterceptor())
                            .connectTimeout(10, TimeUnit.SECONDS)
                            .readTimeout(10, TimeUnit.SECONDS)
                            .build();

        Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ApiService.API_SERVER_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(okHttpClient)
                        .build();
        return retrofit;
    }

    class CacheNetworkInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Log.d("786554", "1");
            // 无缓存，进行最大60秒缓存
            return chain.proceed(chain.request()).newBuilder()
                    .removeHeader("Pragma")
                    .addHeader("Cache-Control", "max-age=60")
                    .build();
        }
    }

    static class CacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Response response;
            Request request;
            // 有网络检查10秒内的缓存
            if (NetworkUtils.isNetworkAvailable(AppHome.getContext())) {
                Log.d("786554", "2");
                request = chain.request()
                        .newBuilder()
                        .cacheControl(new CacheControl
                                .Builder()
                                .maxAge(10, TimeUnit.SECONDS)
                                .build())
                        .build();
            } else {
                Log.d("786554", "3");
                // 无网络检查30天内的缓存，即使是过期的
                request = chain.request()
                        .newBuilder()
                        .cacheControl(new CacheControl
                                .Builder()
                                .maxAge(30, TimeUnit.DAYS)
                                .build())
                        .build();
            }
            response = chain.proceed(request);
            return response.newBuilder().build();
        }
    }
}
