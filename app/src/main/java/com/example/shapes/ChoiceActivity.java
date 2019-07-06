package com.example.shapes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ChoiceActivity extends Activity
{
    RadioButton circleRadioButton, triangleRadioButton, rectangleRadioButton;
    RadioGroup radioGroup;
    Button startButton;

    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        circleRadioButton = findViewById(R.id.circleRadioButton);
        triangleRadioButton = findViewById(R.id.triangleRadioButton);
        rectangleRadioButton = findViewById(R.id.rectangleRadioButton);
        radioGroup = findViewById(R.id.radioGroup);
        startButton = findViewById(R.id.startButton);

        circleRadioButton.setChecked(true);

        startButton.setOnClickListener( v ->
        {
            int choice = radioGroup.getCheckedRadioButtonId();
            String result = "";

            switch(choice)
            {
                case R.id.circleRadioButton:    result = "circle";    break;
                case R.id.triangleRadioButton:  result = "triangle";    break;
                case R.id.rectangleRadioButton: result = "rectangle";    break;
            }

            Intent intent = new Intent(this, DrawShapes.class);
            intent.putExtra("shape", result);
            startActivity(intent);

        });
    }
}