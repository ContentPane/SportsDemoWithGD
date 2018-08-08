package com.example.mengqi.sportsdemo.Utils.DrawUtils;

import android.content.Context;
import android.util.Log;

import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.example.mengqi.sportsdemo.Dao.DrawLineDaoImpl;
import java.util.ArrayList;
import java.util.List;

public class DrawOnMap {
    private static final String TAG = "DrawOnMap";
    private Context context;
    private List<LatLng> latiLongsList = new ArrayList<>();
    private DrawLineDaoImpl drawLineFormDB;


    public DrawOnMap(Context context) {
        this.context = context;
        drawLineFormDB = new DrawLineDaoImpl(context);
    }

    //添加路线和箭头
    public List<PolylineOptions> drawRoad(BitmapDescriptor arrowBitmap , int lineWidth) {
        // 查询点
        latiLongsList = drawLineFormDB.queryLatlng();
        Log.d(TAG, "queryLatlng: latitude " + latiLongsList);

        PolylineOptions plOptionsArrow = new PolylineOptions()
                .setCustomTexture(arrowBitmap)
                .zIndex(9)
                .width(lineWidth)
                .color(0xFFFF0000);
        plOptionsArrow.setPoints(latiLongsList);

        PolylineOptions plOptionsRoad = new PolylineOptions()
                .zIndex(8)
                .width(lineWidth)
                .color(0xFF9400D3);
        plOptionsRoad.setPoints(latiLongsList);

        List<PolylineOptions> plOptionsWithArrow = new ArrayList<>();
        plOptionsWithArrow.add(plOptionsArrow);
        plOptionsWithArrow.add(plOptionsRoad);

        return plOptionsWithArrow;
    }

    public List<MarkerOptions> drawStartAndEnd (BitmapDescriptor startBitmap,BitmapDescriptor endBitmap) {
        // 新建数组存储OverLayOptions
        List<MarkerOptions> startAndEndList = new ArrayList<>();


        // 获取起点和终点的纬度
        LatLng latLngStart = drawLineFormDB.queryStartPointLatlng();
        LatLng latLngEnd = drawLineFormDB.queryEndPointLatlng();
        Log.d(TAG, "drawLine: LatlngStart" + latLngStart);
        Log.d(TAG, "drawLine: LatlngEnd" + latLngEnd);

        MarkerOptions startMarkerOptions = new MarkerOptions()
                .zIndex(5)
                .icon(startBitmap)
                .position(latLngStart);

        MarkerOptions endMarkerOptions = new MarkerOptions()
                .zIndex(5)
                .icon(endBitmap)
                .position(latLngEnd);

        startAndEndList.add(startMarkerOptions);
        startAndEndList.add(endMarkerOptions);
        return startAndEndList;
    }
}
