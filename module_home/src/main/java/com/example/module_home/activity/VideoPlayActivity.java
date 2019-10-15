package com.example.module_home.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.module_home.R;
import com.example.module_home.data.ContentInfo;
import com.example.module_home.data.VideoRecommend;
import com.example.module_home.media.IjkPlayerView;
import com.example.module_home.mvp.contract.VideoContract;
import com.example.module_home.mvp.presenter.VideoPresenter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class VideoPlayActivity extends AppCompatActivity implements VideoContract.View {
    private VideoPresenter videoPresenter;
    private IjkPlayerView ijkPlayerView;
    private InputStream stream = null;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.h_activity_video_play);
        videoPresenter = new VideoPresenter(this, this);
        id = getIntent().getStringExtra("id");
        videoPresenter.getContentInfo(id);
        ijkPlayerView = findViewById(R.id.ijkplayer);
        try {
            stream = getAssets().open("custom.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
        if (ijkPlayerView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ijkPlayerView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ijkPlayerView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        ijkPlayerView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ijkPlayerView.onDestroy();
    }

    @Override
    public void setData(ContentInfo contentInfo) {
        ijkPlayerView.init(contentInfo.getContent().getPic())
                .createParser(stream)
                .setVideoPath(contentInfo.getContent().getVideos().get(1).getUrl())
                .setTitle(contentInfo.getContent().getName());

    }
}
