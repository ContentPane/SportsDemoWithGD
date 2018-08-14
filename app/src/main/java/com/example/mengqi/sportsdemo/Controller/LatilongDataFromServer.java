package com.example.mengqi.sportsdemo.Controller;

import com.example.mengqi.sportsdemo.Model.LatiLong;
import com.example.mengqi.sportsdemo.Utils.DrawUtils.GsonUtils;
import com.example.mengqi.sportsdemo.Utils.DrawUtils.HttpUtils;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LatilongDataFromServer {

    static ArrayList<LatiLong> latiLongList;

    public static ArrayList<LatiLong> getLatiLongFromJson() {

        HttpUtils.sendOkHttpRequest("http://127.0.0.1:8080/latilong.json", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                latiLongList = GsonUtils.jsonToArrayList(json, LatiLong.class, "latilong");
                for (LatiLong latiLong : latiLongList) {
                    System.out.println(latiLong.getLatitude() + " " + latiLong.getLongtitude());
                }
            }

        });
        System.out.println(latiLongList);
        return latiLongList;
    }

    public static void main(String[] args) {
        getLatiLongFromJson();
    }

}
