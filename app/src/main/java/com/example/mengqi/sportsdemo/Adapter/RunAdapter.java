package com.example.mengqi.sportsdemo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mengqi.sportsdemo.Fragments.Fragment_freeMode;
import com.example.mengqi.sportsdemo.Fragments.Fragment_randomMode;
import com.example.mengqi.sportsdemo.Fragments.Fragment_runTogether;

public class RunAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"自由模式","随机终点","约跑模式"};


    public RunAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new Fragment_randomMode();
        } else if (position == 2) {
            return new Fragment_runTogether();
        }
        return new Fragment_freeMode();

    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
