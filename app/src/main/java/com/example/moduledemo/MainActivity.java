package com.example.moduledemo;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Fragment homeFragment;
    private Fragment communityFragment;
    private Fragment userFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this.getApplication()); // 尽可能早，推荐在Application中初始化

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
                        beginTransaction.hide(communityFragment).hide(userFragment);
                        beginTransaction.show(homeFragment);
                        beginTransaction.commit();
                        break;
                    case R.id.community:
                        beginTransaction.hide(homeFragment).hide(userFragment);
                        beginTransaction.show(communityFragment);
                        beginTransaction.commit();
                        break;
                    case R.id.user:
                        beginTransaction.hide(homeFragment).hide(communityFragment);
                        beginTransaction.show(userFragment);
                        beginTransaction.commit();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    private void init() {
        homeFragment = (Fragment) ARouter.getInstance().build("/home/fragment").navigation();
        communityFragment = (Fragment) ARouter.getInstance().build("/community/fragment").navigation();
        userFragment = (Fragment) ARouter.getInstance().build("/user/fragment").navigation();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, homeFragment).add(R.id.frameLayout, communityFragment).add(R.id.frameLayout, userFragment);
        fragmentTransaction.hide(communityFragment).hide(userFragment);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


}
