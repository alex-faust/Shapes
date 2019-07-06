package com.example.shapes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

public class Rectangle
{
    private int radius, color;
    Point a, b, c, d;

    private Paint paint;
    private Canvas canvas;
    private Path path = new Path();

    public Rectangle(int minRadius, int maxRadius, int maxW, int maxH, Canvas can)
    {
        canvas = can;
        radius = rand(minRadius, maxRadius);
        a = new Point(rand(radius, maxW - radius), rand(radius, maxH - radius));
        b = new Point(a.x + 100, a.y);
        c = new Point(a.x + 100, a.y - 50);
        d = new Point(a.x, a.y - 50);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        color = Color.argb(rand(0, 255), rand(0, 255), rand(0, 255), rand(0, 255));
        paint.setColor(color);
        paint.setStrokeWidth(2);

    }

    public void draw()
    {
        path.moveTo(a.x, a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(d.x, d.y);
        path.lineTo(a.x, a.y);
        path.close();
        canvas.drawPath(path, paint);
    }

    public int rand(int ax, int bx)
    {
        return (int) ((bx - ax + 1) * Math.random() + ax);
    }
}
