package com.kuanggang.androidcustomview.widget.customview.class1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author KG on 2017/8/14.
 */

public class CustomView1 extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CustomView1(Context context) {
        super(context);
    }

    public CustomView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 覆盖半透明模板
        canvas.drawColor(Color.parseColor("#88880000"));
        // 覆盖底色
        canvas.drawColor(Color.BLACK);

        // 画圆
        mPaint.setColor(Color.RED);
        canvas.drawCircle(250, 300, 200, mPaint);

        // 画空心圆
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setAntiAlias(false); // 抗锯齿
        canvas.drawCircle(800, 300, 200, mPaint);

        // 画方形
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(30);
        mPaint.setAntiAlias(true);
        canvas.drawRect(50, 550, 350, 750, mPaint);

        // 画点
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(50); // 线框的粗细(点的大小)
        mPaint.setStrokeCap(Paint.Cap.SQUARE); // 线条端点的形状（点的样式），端点有圆头 (ROUND)、平头 (BUTT) 和方头 (SQUARE)
        canvas.drawPoint(50, 50, mPaint);

        // 画多个点
        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
        // 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
        canvas.drawPoints(points, 2 /* 跳过两个数，即前两个 0 */, 8 /* 一共绘制 8 个数（4 个点）*/, mPaint);
    }
}
