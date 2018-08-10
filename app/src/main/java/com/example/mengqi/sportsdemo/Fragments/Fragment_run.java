package com.example.mengqi.sportsdemo.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.mengqi.sportsdemo.Event.ScreenEvent;
import com.example.mengqi.sportsdemo.R;
import com.example.mengqi.sportsdemo.Utils.DrawUtils.RunAnimUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment_run extends BaseFragment{

    private static final String TAG = "Fragment_run";


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.run_fragment, null);
        ButterKnife.bind(this,view);
        return view;
    }


}
