package com.example.mengqi.sportsdemo.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mengqi.sportsdemo.R;

public class Fragment_mine extends BaseFragment {
    private static final String TAG = Fragment_mine.class.getSimpleName();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container,false);
        return view;
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        if (isVisible) {

        } else {

        }
    }

    @Override
    protected void onFragmentFirstVisible() {

    }
}
