package com.example.barick.myapplication;

import android.content.Context;
import android.media.Image;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button History;
        History = (Button) findViewById(R.id.history_button);
        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,History.class));
            }
        });
        Button pop;
        pop = (Button) findViewById(R.id.startbutton);
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,pop.class));

            }
        });

        int points=22;
        if(50 > points) {
            ImageView hats = (ImageView) findViewById(R.id.hats);
            hats.setVisibility(View.INVISIBLE);
        
        }
        if(40 > points) {
            ImageView shade = (ImageView) findViewById(R.id.shades);
            shade.setVisibility(View.INVISIBLE);
        }
        if(30 > points) {
            ImageView shirt = (ImageView) findViewById(R.id.shirts);
            shirt.setVisibility(View.INVISIBLE);
        }
        if(20 > points) {
            ImageView pants = (ImageView) findViewById(R.id.pants);
            pants.setVisibility(View.INVISIBLE);
        }
    }
}
