package com.example.shapes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circle
{
    private int cx, cy, radius, color;
    private Paint paint;
    private Canvas canvas;

    public Circle(int minRadius, int maxRadius, int maxW, int maxH, Canvas c)
    {
        canvas = c;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        radius = rand(minRadius, maxRadius);
        cx = rand(radius, maxW - radius);
        cy = rand(radius, maxH - radius);
        color = Color.argb(rand(0,255), rand(0,255), rand(0,255), rand(0,255));
        paint.setColor(color);
    }

    public void draw()
    {
        canvas.drawCircle(cx, cy, radius, paint);
    }


    public int rand(int a, int b)
    {
        return (int) ((b - a + 1) * Math.random() + a);
    }
}