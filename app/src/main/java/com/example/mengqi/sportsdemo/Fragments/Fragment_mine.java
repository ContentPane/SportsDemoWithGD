package com.example.mengqi.sportsdemo.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mengqi.sportsdemo.R;
import com.xiaosu.view.text.DataSetAdapter;
import com.xiaosu.view.text.VerticalRollingTextView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_mine extends BaseFragment {
    private static final String TAG = Fragment_mine.class.getSimpleName();
    VerticalRollingTextView notice;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container,false);
        notice = (VerticalRollingTextView) view.findViewById(R.id.notice);
        List<CharSequence> mDataset = new ArrayList<>();
        mDataset.add("渭城朝雨浥轻尘，客舍青青杨柳春。劝君更尽一杯酒，西出阳关无故人。劝君更尽一杯酒，西出阳关无故人。");
        mDataset.add("劝君更尽一杯酒，西出阳关无故人。渭城朝雨浥轻尘，客舍青青杨柳春。");
        mDataset.add("劝君更尽一杯酒，西出阳关无故人。渭城朝雨浥轻尘，客舍青青杨柳春。渭城朝雨浥轻尘，客舍青青杨柳春。");
        notice.setDataSetAdapter(new DataSetAdapter<CharSequence>(mDataset) {
            @Override
            protected CharSequence text(CharSequence charSequence) {
                return charSequence;
            }
        });
        notice.run();
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
