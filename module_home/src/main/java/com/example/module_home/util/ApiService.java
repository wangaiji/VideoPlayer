package com.example.module_home.util;

import com.example.module_home.data.ContentInfo;
import com.example.module_home.data.VideoMessage;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiService {
    String API_SERVER_URL = "http://app.pearvideo.com/clt/jsp/v2/";

    @Headers({
            "X-Channel-Code: official",
            "X-Client-Agent: Xiaomi",
            "X-Client-Hash: 2f3d6ffkda95dlz2fhju8d3s6dfges3t",
            "X-Client-ID: 123456789123456",
            "X-Client-Version: 2.3.2",
            "X-Long-Token: ",
            "X-Platform-Type: 0",
            "X-Platform-Version: 5.0",
            "X-Serial-Num: 1492140134",
            "X-User-ID: "
    })
    @FormUrlEncoded
    @POST("getCategoryConts.jsp")
    Observable<VideoMessage> getVideoMessageCall(@Field("categoryId") String categoryId);

    @Headers({
            "X-Channel-Code: official",
            "X-Client-Agent: Xiaomi",
            "X-Client-Hash: 2f3d6ffkda95dlz2fhju8d3s6dfges3t",
            "X-Client-ID: 123456789123456",
            "X-Client-Version: 2.3.2",
            "X-Long-Token: ",
            "X-Platform-Type: 0",
            "X-Platform-Version: 5.0",
            "X-Serial-Num: 1492140134",
            "X-User-ID: "
    })
    @GET
    Observable<VideoMessage> getHotMessageCall(@Url String url);

    @Headers({
            "X-Channel-Code: official",
            "X-Client-Agent: Xiaomi",
            "X-Client-Hash: 2f3d6ffkda95dlz2fhju8d3s6dfges3t",
            "X-Client-ID: 123456789123456",
            "X-Client-Version: 2.3.2",
            "X-Long-Token: ",
            "X-Platform-Type: 0",
            "X-Platform-Version: 5.0",
            "X-Serial-Num: 1492140134",
            "X-User-ID: "
    })
    @GET("content.jsp")
    Observable<ContentInfo> getContentInfoCall(@Query("contId") String contId);

}
