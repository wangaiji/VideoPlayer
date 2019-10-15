package com.example.module_home.mvp.contract;

import com.example.module_home.base.BasePresenter;
import com.example.module_home.base.BaseView;
import com.example.module_home.data.ContentInfo;
import com.example.module_home.data.VideoRecommend;

import java.util.List;
import java.util.Map;

public interface VideoContract {
    interface View extends BaseView {
        void setData(ContentInfo videoRecommends);
    }

    abstract class Presenter extends BasePresenter<VideoContract.View> {
        public abstract void getContentInfo(String id);
    }
}
