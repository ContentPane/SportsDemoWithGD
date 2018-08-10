package com.example.mengqi.sportsdemo.Activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.blankj.utilcode.util.BarUtils;
import com.example.mengqi.sportsdemo.Adapter.TabFragmentPagerAdapter;
import com.example.mengqi.sportsdemo.Fragments.Fragment_mine;
import com.example.mengqi.sportsdemo.Fragments.Fragment_rank;
import com.example.mengqi.sportsdemo.Fragments.Fragment_runship;
import com.example.mengqi.sportsdemo.Fragments.Fragment_score;
import com.example.mengqi.sportsdemo.R;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "FirstActivity";
    ViewPager mViewPager;
    List<Fragment> mFragmentList;
    RelativeLayout tab_score;
    RelativeLayout tab_rank;
    RelativeLayout tab_runship;
    RelativeLayout tab_mine;

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
        mViewPager = (ViewPager) findViewById(R.id.myViewPager);
        mFragmentList = new ArrayList<>();
        tab_score = (RelativeLayout) findViewById(R.id.tab_score);
        tab_rank = (RelativeLayout) findViewById(R.id.tab_rank);
        tab_runship = (RelativeLayout) findViewById(R.id.tab_runship);
        tab_mine = (RelativeLayout) findViewById(R.id.tab_mine);

        Fragment_mine fragment_mine = new Fragment_mine();
        Fragment_rank fragment_rank = new Fragment_rank();
        Fragment_runship fragment_runship = new Fragment_runship();
        Fragment_score fragment_score = new Fragment_score();
        mFragmentList.add(fragment_score);
        mFragmentList.add(fragment_rank);
        mFragmentList.add(fragment_runship);
        mFragmentList.add(fragment_mine);

        FragmentManager fragmentManager = getSupportFragmentManager();
        TabFragmentPagerAdapter fragmentAdapter = new TabFragmentPagerAdapter(fragmentManager, mFragmentList);

        mViewPager.setAdapter(fragmentAdapter);
        mViewPager.setCurrentItem(0, true);

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
        tab_runship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(2);
            }
        });
        tab_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(3);
            }
        });
    }



}
