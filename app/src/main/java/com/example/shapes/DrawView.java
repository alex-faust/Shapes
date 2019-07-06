package com.example.shapes;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class DrawView extends View
{
    private int minShapeSize, maxShapeSize, canvasW, canvasH;
    private Canvas canvas;
    private ArrayList<Circle> circles;
    private ArrayList<Triangle> triangles;
    private ArrayList<Rectangle> rectangles;

    public DrawView(Context con, AttributeSet as)
    {
        super(con, as);
        circles = new ArrayList<>();
        triangles = new ArrayList<>();
        rectangles = new ArrayList<>();
    }
    public DrawView(Context con)
    {
        super(con);
    }

    @Override
    public void onDraw(Canvas c)
    {
        canvas = c;
        for (Circle cir : circles) cir.draw();
        for (Triangle tri: triangles) tri.draw();
        for (Rectangle rect: rectangles) rect.draw();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        canvasW = w;
        canvasH = h;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public void addCircle()
    {
        minShapeSize = 10;
        maxShapeSize = 90;
        circles.add(new Circle(minShapeSize, maxShapeSize, canvasW, canvasH, canvas));
        invalidate();
    }

    public void addTriangle()
    {
        minShapeSize = 10;
        maxShapeSize = 90;
        triangles.add(new Triangle(minShapeSize, maxShapeSize, canvasW, canvasH, canvas));
        invalidate();
    }

    public void addRectangle()
    {
        minShapeSize = 10;
        maxShapeSize = 90;
        rectangles.add(new Rectangle(minShapeSize, maxShapeSize, canvasW, canvasH, canvas));
        invalidate();
    }

    public void clearShape()
    {
        circles.clear();
        triangles.clear();
        rectangles.clear();
        invalidate();
    }
}