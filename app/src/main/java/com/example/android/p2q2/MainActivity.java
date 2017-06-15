package com.example.android.p2q2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText point_1_x_field, point_1_y_field, point_2_x_field, point_2_y_field;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private double p_1_x, p_1_y, p_2_x, p_2_y, x_midpoint, y_midpoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab_done);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                point_1_x_field = (EditText) findViewById(R.id.point_1_x);
                point_1_y_field = (EditText) findViewById(R.id.point_1_y);
                point_2_x_field = (EditText) findViewById(R.id.point_2_x);
                point_2_y_field = (EditText) findViewById(R.id.point_2_y);

                p_1_x = Double.parseDouble(point_1_x_field.getText().toString());
                p_1_y = Double.parseDouble(point_1_y_field.getText().toString());
                p_2_x = Double.parseDouble(point_2_x_field.getText().toString());
                p_2_y = Double.parseDouble(point_2_y_field.getText().toString());

                x_midpoint = (p_1_x + p_2_x) / 2.0;
                y_midpoint = (p_1_y + p_2_y) / 2.0;
                Point midpoint = new Point(x_midpoint, y_midpoint);

                Intent intent = new Intent(MainActivity.this, DisplayMidpointActivity.class);
                intent.putExtra("POINT", midpoint);
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.action_setting: {
                Toast.makeText(MainActivity.this, "You clicked setting", Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.action_favourite: {
                Toast.makeText(MainActivity.this, "You clicked your favourite activities", Toast.LENGTH_SHORT).show();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


