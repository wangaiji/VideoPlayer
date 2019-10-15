package com.example.module_home.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.module_home.R;
import com.example.module_home.widgets.ColorImageView;

public class ColorViewHolder extends RecyclerView.ViewHolder {
    public ColorImageView colorButton;

    public ColorViewHolder(View itemView) {
        super(itemView);
        colorButton = itemView.findViewById(R.id.color_button);
    }
}
