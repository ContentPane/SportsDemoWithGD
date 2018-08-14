package com.example.mengqi.sportsdemo.Utils.DrawUtils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.mengqi.sportsdemo.R;

public class CircleProgressBar extends View {
    //进度条背景色
    private int mCircleBgColor = Color.BLUE;
    //进度条文字展示颜色
    private int mTextColor = Color.GRAY;
    //进度条宽度
    private float mCircleWidth = 50;
    //进度条颜色
    private int mProgressColor = Color.GREEN;

    private int progress;
    private int max = 100;

    private Paint paint = new Paint();

    public CircleProgressBar(Context context) {
        super(context);
        init(context,null);
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    public void init(Context context,AttributeSet attrs){
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.CircleProgressBar);
        mCircleBgColor = array.getColor(R.styleable.CircleProgressBar_mCircleBgColor,Color.BLUE);
        mProgressColor = array.getColor(R.styleable.CircleProgressBar_mProgressColor,Color.GREEN);
        mCircleWidth = array.getDimension(R.styleable.CircleProgressBar_mCircleWidth,50);
        array.recycle();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画背景
        paint.setColor(mCircleBgColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(mCircleWidth);
        int center = getWidth() / 2;

        int radius = (int) (center - mCircleWidth / 2);
        canvas.drawCircle(center,center,radius,paint);


        //画弧形
        RectF oval = new RectF(center - radius,center - radius,center + radius,center + radius);
        paint.setStrokeWidth(mCircleWidth);
        paint.setColor(mProgressColor);
        paint.setStrokeCap(Paint.Cap.ROUND);

        canvas.drawArc(oval,-90,360 * progress/max,false,paint);
    }

    //设置进度条
    public void setProgress(int progress){
        if (progress > max){
            progress = max;
        }
        if (progress <= max){
            this.progress = progress;
            postInvalidate();
        }
    }
}
