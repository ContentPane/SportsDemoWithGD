package com.example.mengqi.sportsdemo.Activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.support.design.widget.TabLayout;

import com.example.mengqi.sportsdemo.Adapter.RunAdapter;
import com.example.mengqi.sportsdemo.Adapter.TabFragmentPagerAdapter;
import com.example.mengqi.sportsdemo.Fragments.Fragment_mine;
import com.example.mengqi.sportsdemo.Fragments.Fragment_rank;
import com.example.mengqi.sportsdemo.Fragments.Fragment_runship;
import com.example.mengqi.sportsdemo.Fragments.Fragment_score;
import com.example.mengqi.sportsdemo.R;
import com.example.mengqi.sportsdemo.Utils.DrawUtils.RunAnimUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "FirstActivity";

    @BindView(R.id.mainInterface)
    LinearLayout mainInterface;
    @BindView(R.id.myViewPager)
    ViewPager mViewPager;
    @BindView(R.id.tab_score)
    RelativeLayout tab_score;
    @BindView(R.id.tab_rank)
    RelativeLayout tab_rank;
    @BindView(R.id.tab_runship)
    RelativeLayout tab_runship;
    @BindView(R.id.tab_mine)
    RelativeLayout tab_mine;
    @BindView(R.id.runbackground)
    FrameLayout runbackground;
    @BindView(R.id.runbackground_cancel)
    ImageView cancel_runbackground;
    @BindView(R.id.run_icon)
    CircleImageView runIcon;
    @BindView(R.id.run_viewpager)
    ViewPager runViewPager;
    @BindView(R.id.run_tablayout)
    TabLayout runTabLayout;


    int width;
    int height;
    List<Fragment> mFragmentList;

    private final Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        // 状态栏透明化
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        ButterKnife.bind(this);

        RunAdapter runAdapter = new RunAdapter(getSupportFragmentManager());
        runViewPager.setAdapter(runAdapter);
        runTabLayout.setupWithViewPager(runViewPager);



        //底部TabLayout绑定ViewPager和Fragement初始化
        mFragmentList = new ArrayList<>();
        Fragment_mine fragment_mine = new Fragment_mine();
        Fragment_rank fragment_rank = new Fragment_rank();
        Fragment_runship fragment_runship = new Fragment_runship();
        Fragment_score fragment_score = new Fragment_score();
        mFragmentList.add(fragment_score);
        mFragmentList.add(fragment_rank);
        mFragmentList.add(fragment_runship);
        mFragmentList.add(fragment_mine);


        TabFragmentPagerAdapter fragmentAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);

        mViewPager.setAdapter(fragmentAdapter);
        mViewPager.setCurrentItem(0, true);

        // 获取屏幕宽高确定圆形动画原点
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        width = metrics.widthPixels;
        height = metrics.heightPixels;

        // 成绩页面
        tab_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(0);
            }
        });

        // 排行页面
        tab_rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(1);
            }
        });

        // 跑步启动动画
        runIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RunAnimUtils.handleAnimate(runbackground, width / 2, height);
                if (runbackground.getVisibility() == View.INVISIBLE) {
                    runbackground.setVisibility(View.VISIBLE);
                    runbackground.setClickable(true);
                }

            }
        });

        // 跑步取消动画
        cancel_runbackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RunAnimUtils.handleAnimate(runbackground, width / 2, height);
                if (runbackground.getVisibility() == View.VISIBLE) {
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            runbackground.setVisibility(View.INVISIBLE);
                            runbackground.setClickable(false);
                        }
                    };
                    mHandler.postDelayed(runnable,400);
                    mHandler.removeCallbacks(runnable);
                }
            }
        });

        // 跑圈页面
        tab_runship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(2);
            }
        });

        // 我的页面
        tab_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(3);
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }


}
