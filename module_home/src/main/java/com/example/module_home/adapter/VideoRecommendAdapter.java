package com.example.module_home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.module_home.R;
import com.example.module_home.data.VideoRecommend;
import com.example.module_home.holder.VideoViewHolder;

import java.util.ArrayList;
import java.util.List;

public class VideoRecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<VideoRecommend> mVideoRecommendList = new ArrayList<>();
    private OnItemClickListener mItemClickListener;
    private String mItemText;

    public VideoRecommendAdapter(List<VideoRecommend> mVideoRecommendList) {
       this.mVideoRecommendList.clear();
       this.mVideoRecommendList.addAll(mVideoRecommendList);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.h_video_item, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        final VideoViewHolder holder = (VideoViewHolder) viewHolder;
        holder.videoName.setText(mVideoRecommendList.get(position).getName());
        Glide.with(mContext).load(mVideoRecommendList.get(position).getImageUrl()).into(holder.videoImage);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemText = holder.videoName.getText().toString();
                    mItemClickListener.onClick(position);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mVideoRecommendList.size();
    }

    public String getItemText() {
        return mItemText;
    }

    public void setVideoRecommendList(List<VideoRecommend> videoRecommendList) {
        mVideoRecommendList.clear();
        mVideoRecommendList.addAll(videoRecommendList);
    }

    public void addData(int position, List<VideoRecommend> list) {
        Log.d("2748764", mVideoRecommendList.toString() + "  6");
        mVideoRecommendList.addAll(list);
        notifyItemRangeInserted(position, list.size());
        Log.d("2748764",  mVideoRecommendList.toString() + "  65");
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public void setItemClickListener(OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }
}
