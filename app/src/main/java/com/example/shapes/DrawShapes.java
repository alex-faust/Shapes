package com.example.shapes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class DrawShapes extends Activity
{
    DrawView dv;
    Button drawButton, clearButton;

    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.draw_shapes);
        dv = findViewById(R.id.canvas);
        drawButton = findViewById(R.id.drawButton);
        clearButton = findViewById(R.id.clearButton);

        if (getIntent() == null)
        {
            Toast.makeText(this, "No Activity called me", Toast.LENGTH_LONG).show();
        }

        Intent intent = getIntent();
        String shape = intent.getStringExtra("shape");

        drawButton.setOnClickListener(v ->
        {
            switch(shape)
            {
                case "circle" :     dv.addCircle();     break;
                case "triangle":    dv.addTriangle();   break;
                case "rectangle":   dv.addRectangle();  break;
            }
        });

        clearButton.setOnClickListener(v -> dv.clearShape());
    }
}