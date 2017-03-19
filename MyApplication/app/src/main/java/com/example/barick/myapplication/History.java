package com.example.barick.myapplication;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.*;
import java.io.InputStream;
import java.util.StringTokenizer;

/**
 * Created by Barick on 2017-03-18.
 */

public class History extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        Button Back;
        Back = (Button)findViewById(R.id.back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(History.this,MainActivity.class));

            }
        });
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("history.txt"), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;
            String data[]=new String[12];
            int counter = 0;
            while ((mLine = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(mLine);
                while (st.hasMoreTokens()) {
                    data[counter] =st.nextToken();
                    data[counter+1] =st.nextToken();
                    counter++;
                    counter++;
                }

            }
            TextView date1 = (TextView) findViewById(R.id.date1);
            date1.setText(data[1]);
            TextView date2 = (TextView) findViewById(R.id.date2);
            date2.setText(data[3]);
            TextView date3 = (TextView) findViewById(R.id.date3);
            date3.setText(data[5]);
            TextView date4 = (TextView) findViewById(R.id.date4);
            date4.setText(data[7]);
            TextView date5 = (TextView) findViewById(R.id.date5);
            date5.setText(data[9]);
            TextView date6 = (TextView) findViewById(R.id.date6);
            date6.setText(data[11]);
            TextView score1 = (TextView) findViewById(R.id.score1);
            score1.setText(data[2]);
            TextView score2 = (TextView) findViewById(R.id.score2);
            score2.setText(data[4]);
            TextView score3 = (TextView) findViewById(R.id.score3);
            score3.setText(data[6]);
            TextView score4 = (TextView) findViewById(R.id.score4);
            score4.setText(data[8]);
            TextView score5 = (TextView) findViewById(R.id.score5);
            score5.setText(data[10]);
            TextView score0 = (TextView) findViewById(R.id.score0);
            score0.setText(data[0]);

        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        };
    }

}

