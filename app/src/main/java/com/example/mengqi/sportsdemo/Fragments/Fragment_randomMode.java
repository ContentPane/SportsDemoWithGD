package com.example.mengqi.sportsdemo.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mengqi.sportsdemo.Activity.MainActivity;
import com.example.mengqi.sportsdemo.R;
import com.example.mengqi.sportsdemo.Utils.DrawUtils.DiffuseView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment_randomMode extends BaseFragment {
    @BindView(R.id.spreadView_random)
    DiffuseView mDiffuseView;
    @BindView(R.id.randomrun_begin)
    Button randomRunBeginButton;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.randomrun_fragment, null);
        ButterKnife.bind(this,view);
        mDiffuseView.start();
        randomRunBeginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
