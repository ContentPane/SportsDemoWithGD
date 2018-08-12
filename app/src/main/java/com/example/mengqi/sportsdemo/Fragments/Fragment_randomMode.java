package com.example.mengqi.sportsdemo.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mengqi.sportsdemo.R;
import com.example.mengqi.sportsdemo.Utils.DrawUtils.DiffuseView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment_randomMode extends BaseFragment {
    @BindView(R.id.spreadView_random)
    DiffuseView mDiffuseView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.randomrun_fragment, null);
        ButterKnife.bind(this,view);
        mDiffuseView.start();
        return view;
    }
}
