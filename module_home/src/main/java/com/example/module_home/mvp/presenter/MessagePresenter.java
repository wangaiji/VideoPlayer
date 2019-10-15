package com.example.module_home.mvp.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.module_home.data.VideoMessage;
import com.example.module_home.data.VideoRecommend;
import com.example.module_home.mvp.contract.MessageContract;
import com.example.module_home.util.RetrofitUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class MessagePresenter extends MessageContract.Presenter {
    private Map<String, String> mVideoRcList = new HashMap<>();
    private List<VideoRecommend> recommendList = new ArrayList<>();
    private Context mContext;
    private String mHotUrl;

    public MessagePresenter(Context context, MessageContract.View view) {
        mContext = context;
        attachView(view);
    }

    @Override
    public void getVideoMessage(String id) {
        Observable<VideoMessage> observable = RetrofitUtils.getApiService().getVideoMessageCall(id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<VideoMessage>() {
                    @Override
                    public void accept(VideoMessage videoMessage) throws Exception {
                        if (videoMessage != null) {
                            if (videoMessage.getResultCode().equals("1") && videoMessage.getResultMsg().equals("success")) {
                                recommendList.clear();
                                if (getView().getDataName().equals("最热")) {
                                    for (VideoMessage.HotListBean hotListBean : videoMessage.getHotList()) {
                                        recommendList.add(new VideoRecommend(hotListBean.getName(), hotListBean.getPic()));
                                        mVideoRcList.put(hotListBean.getName(), hotListBean.getContId());
                                    }
                                    if (mVideoRcList.size() % 2 != 0) {
                                        recommendList.add(new VideoRecommend(videoMessage.getContList().get(0).getName(), videoMessage.getContList().get(0).getPic()));
                                        mVideoRcList.put(videoMessage.getContList().get(0).getName(), videoMessage.getContList().get(0).getContId());
                                    }
                                    if (recommendList != null) {
                                        getView().setData(recommendList);
                                    }
                                } else if (getView().getDataName().equals("最新")) {
                                    int length = videoMessage.getContList().size();
                                    if ((length - 1) % 2 != 0) {
                                        length = length - 1;
                                    }
                                    for (int i = 1; i < length; i++) {
                                        recommendList.add(new VideoRecommend(videoMessage.getContList().get(i).getName(), videoMessage.getContList().get(i).getPic()));
                                        mVideoRcList.put(videoMessage.getContList().get(i).getName(), videoMessage.getContList().get(i).getContId());
                                    }
                                    if (recommendList != null) {
                                        getView().setData(recommendList);
                                    }
                                }

                                if (mHotUrl == null) {
                                    mHotUrl = videoMessage.getNextUrl();
                                }
                            } else {
                                Toast.makeText(mContext, "请求失败", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<VideoMessage, ObservableSource<VideoMessage>>() {
                    @Override
                    public ObservableSource<VideoMessage> apply(VideoMessage videoMessage) throws Exception {
                        return RetrofitUtils.getApiService().getHotMessageCall(mHotUrl);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoMessage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideoMessage videoMessage) {
                        if (videoMessage != null) {
                            Log.d("2985437",videoMessage.toString());
                            if (videoMessage.getResultCode().equals("1") && videoMessage.getResultMsg().equals("success")) {
                                if (getView().getDataName().equals("热门")) {
                                    mHotUrl = videoMessage.getNextUrl();
                                    for (VideoMessage.ContListBean contListBean : videoMessage.getContList()) {
                                        recommendList.add(new VideoRecommend(contListBean.getName(), contListBean.getPic()));
                                        mVideoRcList.put(contListBean.getName(), contListBean.getContId());
                                    }
                                    if (recommendList != null) {
                                            getView().refreshData(recommendList);
                                    }
                                    getView().stopRefresh();
                                }
                            }else {
                                Log.d("29854375","1");
                                getView().stopRefresh();
                                Toast.makeText(mContext, "请求失败", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("29854375","2");
                        if (getView() != null) {
                            getView().stopRefresh();
                        }
                        Toast.makeText(mContext, "请求失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public Map<String, String> getVideoList() {
        return mVideoRcList;
    }


}
