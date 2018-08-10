package com.example.mengqi.sportsdemo.Activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.blankj.utilcode.util.BarUtils;
import com.example.mengqi.sportsdemo.Adapter.TabFragmentPagerAdapter;
import com.example.mengqi.sportsdemo.Event.ScreenEvent;
import com.example.mengqi.sportsdemo.Fragments.Fragment_mine;
import com.example.mengqi.sportsdemo.Fragments.Fragment_rank;
import com.example.mengqi.sportsdemo.Fragments.Fragment_run;
import com.example.mengqi.sportsdemo.Fragments.Fragment_runship;
import com.example.mengqi.sportsdemo.Fragments.Fragment_score;
import com.example.mengqi.sportsdemo.R;
import com.example.mengqi.sportsdemo.Utils.DrawUtils.RunAnimUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    @BindView(R.id.tab_blank)
    RelativeLayout tab_blank;
    @BindView(R.id.runbackground)
    FrameLayout runbackground;
    @BindView(R.id.runbackground_cancel)
    ImageView cacel_runbackground;
    List<Fragment> mFragmentList;

    int width;
    int height;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        ButterKnife.bind(this);


        mFragmentList = new ArrayList<>();

        Fragment_run fragment_run = new Fragment_run();
        Fragment_mine fragment_mine = new Fragment_mine();
        Fragment_rank fragment_rank = new Fragment_rank();
        Fragment_runship fragment_runship = new Fragment_runship();
        Fragment_score fragment_score = new Fragment_score();
        mFragmentList.add(fragment_score);
        mFragmentList.add(fragment_rank);
        mFragmentList.add(fragment_run);
        mFragmentList.add(fragment_runship);
        mFragmentList.add(fragment_mine);

        FragmentManager fragmentManager = getSupportFragmentManager();
        TabFragmentPagerAdapter fragmentAdapter = new TabFragmentPagerAdapter(fragmentManager, mFragmentList);

        mViewPager.setAdapter(fragmentAdapter);
        mViewPager.setCurrentItem(0, true);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        width = metrics.widthPixels;
        height = metrics.heightPixels;

//        Log.d(TAG, "onCreate:  " + width + " " + height);
//
//        EventBus.getDefault().post(new ScreenEvent(width, height));

        tab_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(0);
            }
        });
        tab_rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(1);
            }
        });

        tab_blank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RunAnimUtils.handleAnimate(runbackground,width/2,height);
                cacel_runbackground.setVisibility(View.VISIBLE);
                mainInterface.setVisibility(View.GONE);
            }
        });

        cacel_runbackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RunAnimUtils.handleAnimate(runbackground,width/2,height);
                cacel_runbackground.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        mainInterface.setVisibility(View.VISIBLE);
                    }

                }, 800);

            }
        });

        tab_runship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(3);
            }
        });
        tab_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(4);
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }


}
