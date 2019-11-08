package com.example.module_home.mvp.presenter;

import android.content.Context;

import com.example.module_home.data.ContentInfo;
import com.example.module_home.data.VideoMessage;
import com.example.module_home.data.VideoModel;
import com.example.module_home.mvp.contract.MessageContract;
import com.example.module_home.mvp.contract.VideoContract;
import com.example.module_home.util.RetrofitUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VideoPresenter extends VideoContract.Presenter {
    private Context mContext;
    private VideoModel mVideoModel;
    private CompositeDisposable mCompositeDisposable;

    public VideoPresenter(Context context, VideoContract.View view) {
        mContext = context;
        attachView(view);
        mVideoModel = new VideoModel();
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getContentInfo(String id) {
        mVideoModel.getInfo(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ContentInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ContentInfo contentInfo) {
                        getView().setData(contentInfo);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void unSubscribe() {
        mCompositeDisposable.clear();
    }
}
