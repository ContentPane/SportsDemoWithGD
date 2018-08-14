package com.example.mengqi.sportsdemo.Utils.DrawUtils;

import com.example.mengqi.sportsdemo.Model.LatiLong;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtils {
    private static String json;

    public static <T> ArrayList<T> getLatLngFromJson(String urlPath, Class clazz, String menberName) throws Exception {
        ArrayList<T> arrayList = new ArrayList<>();
        int HttpResult;
        try {
            URL url = new URL(urlPath);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            HttpResult = httpURLConnection.getResponseCode();
            if (HttpResult != HttpURLConnection.HTTP_OK) {
                System.out.println("无法连接");
            } else {
                InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(inputStreamReader);
                StringBuffer buffer = new StringBuffer();
                String line;
                line = reader.readLine();
                while (line != null) {
                    buffer.append(line);
                    line = reader.readLine();
                }
                json = buffer.toString();
            }
            arrayList = GsonUtils.jsonToArrayList(json, clazz, menberName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

}
