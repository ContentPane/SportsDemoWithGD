package com.example.mengqi.sportsdemo.Utils.DrawUtils;

import com.example.mengqi.sportsdemo.Model.LatiLong;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GsonUtils {

    private static Gson gson = null;

    static {
        if (gson == null) {
            gson = new Gson();
        }
    }


    public GsonUtils() {
    }

    public static Object getInstanceByJson(Class<?> clazz, String json) {
        Object object = null;
        Gson gson = new Gson();
        object = gson.fromJson(json, clazz);
        return object;
    }

    public static <T> ArrayList<T> jsonToArrayList(String json, Class<T> clazz, String memberName) {

        ArrayList<T> arrayList = new ArrayList<>();
        JsonArray jsonArray = new JsonParser().parse(json).getAsJsonObject().getAsJsonArray(memberName);

        for (final JsonElement jsonElement : jsonArray) {

            arrayList.add(gson.fromJson(jsonElement, clazz));
        }
        return arrayList;
    }

}
