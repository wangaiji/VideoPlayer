package com.example.moduledemo;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import com.example.module_community.fragment.CommunityFragment;
import com.example.module_home.fragment.HomeFragment;
import com.example.module_user.fragment.UserFragment;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private CommunityFragment communityFragment;
    private UserFragment userFragemnt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//设置透明状态栏
        }
        init();
        bottomNavigationView = findViewById(R.id.navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        beginTransaction.hide(communityFragment).hide(userFragemnt);
                        beginTransaction.show(homeFragment);
                        beginTransaction.commit();
                        break;
                    case R.id.community:
                        beginTransaction.hide(homeFragment).hide(userFragemnt);
                        beginTransaction.show(communityFragment);
                        beginTransaction.commit();
                        break;
                    case R.id.user:
                        beginTransaction.hide(homeFragment).hide(communityFragment);
                        beginTransaction.show(userFragemnt);
                        beginTransaction.commit();
                        break;
                }
                return true;
            }
        });
    }

    private void init() {
        homeFragment = new HomeFragment();
        communityFragment = new CommunityFragment();
        userFragemnt = new UserFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, homeFragment).add(R.id.frameLayout, communityFragment).add(R.id.frameLayout, userFragemnt);
        fragmentTransaction.hide(communityFragment).hide(userFragemnt);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


}
