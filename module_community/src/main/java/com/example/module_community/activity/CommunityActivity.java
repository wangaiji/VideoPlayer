package com.example.module_community.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.module_community.R;
import com.example.module_community.fragment.CommunityFragment;

public class CommunityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_activity_community);
        getSupportFragmentManager().beginTransaction().replace(R.id.community_container, new CommunityFragment()).commit();
    }
}
