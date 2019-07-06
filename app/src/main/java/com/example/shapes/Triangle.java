package com.example.shapes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

public class Triangle
{
    private int radius, color;
    Point a, b, c;

    private Paint paint;
    private Canvas canvas;
    private Path path = new Path();

    Triangle(int minRadius, int maxRadius, int maxW, int maxH, Canvas can)
    {
        canvas = can;
        radius = rand(minRadius, maxRadius);
        a =  new Point(rand(radius, maxW - radius), rand(radius, maxH - radius));
        b = new Point(a.x + 100, a.y);
        c = new Point( a.x + 50, a.y - 100);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        color = Color.argb(rand(0, 255), rand(0, 255), rand(0, 255), rand(0, 255));
        paint.setColor(color);
        paint.setStrokeWidth(2);
    }

    void draw()
    {
        path.moveTo(a.x, a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        path.close();
        canvas.drawPath(path, paint);
    }

    private int rand(int ax, int bx) { return (int) ((bx - ax + 1) * Math.random() + ax); }
}
