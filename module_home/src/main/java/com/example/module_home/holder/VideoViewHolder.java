package com.example.module_home.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.module_home.R;

public class VideoViewHolder extends RecyclerView.ViewHolder {
    public View mView;
    public ImageView videoImage;
    public TextView videoName;

    public VideoViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        videoImage = itemView.findViewById(R.id.h_video_image);
        videoName = itemView.findViewById(R.id.h_video_name);
    }

}
