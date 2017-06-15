package com.example.android.p2q2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;


public class DisplayMidpointActivity extends AppCompatActivity {

    private EditText x_midpoint, y_midpoint;
    private Toolbar toolbar;

    private Point midpoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_midpoint);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        midpoint = (Point) intent.getSerializableExtra("POINT");

        x_midpoint = (EditText) findViewById(R.id.x_midpoint);
        y_midpoint = (EditText) findViewById(R.id.y_midpoint);

        x_midpoint.setText(String.format("%.3f", midpoint.returnX()));
        y_midpoint.setText(String.format("%.3f", midpoint.returnY()));


    }
}
