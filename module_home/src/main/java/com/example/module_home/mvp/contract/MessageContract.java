package com.example.module_home.mvp.contract;

import com.example.module_home.base.BasePresenter;
import com.example.module_home.base.BaseView;
import com.example.module_home.data.VideoRecommend;

import java.util.List;
import java.util.Map;

public interface MessageContract {

    interface View extends BaseView {
        void refreshData(List<VideoRecommend> videoRecommends);
        void setData(List<VideoRecommend> videoRecommends);
        String getDataName();
        void stopRefresh();
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getVideoMessage(String id);
        public abstract String getHotUrl();
    }
}
