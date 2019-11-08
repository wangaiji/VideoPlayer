package com.example.module_home.data;

import com.example.module_home.base.BaseModel;
import com.example.module_home.util.RetrofitUtils;

import io.reactivex.Observable;

public class VideoModel implements BaseModel {
    public Observable<VideoMessage> getMessage(String id) {
        return RetrofitUtils.getApiService().getVideoMessageCall(id);
    }
    public Observable<VideoMessage> getHot(String url) {
        return RetrofitUtils.getApiService().getHotMessageCall(url);
    }
    public Observable<ContentInfo> getInfo(String id){
        return RetrofitUtils.getApiService().getContentInfoCall(id);
    }
}
