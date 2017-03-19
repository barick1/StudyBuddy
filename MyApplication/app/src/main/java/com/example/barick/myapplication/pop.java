package com.example.barick.myapplication;

import android.os.CountDownTimer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Barick on 2017-03-18.
 */
public class pop extends AppCompatActivity{

    EditText editText;
    Button start;
    Button cancel;
    TextView textView;
    CountDownTimer countDownTimer;

    private View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.start:
                    start();
                    break;
                case R.id.cancel:
                    cancel();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);

        editText = (EditText) findViewById(R.id.editText);

        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(btnClickListener);

        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(btnClickListener);
        textView = (TextView) findViewById(R.id.textView);
    }

    private void start() {
        String text = editText.getText().toString();
        int seconds = 60*Integer.valueOf(text);
        if (seconds != 0) {
            countDownTimer = new CountDownTimer(seconds * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                    long minute = millisUntilFinished/60000;
                    long temp = millisUntilFinished/1000;
                    long second = temp%60;
                    if (second < 10){
                        textView.setText(minute+":0"+second);
                    }
                    else {
                        textView.setText(minute + ":" + second);
                    }
                    start.setEnabled(false);
                }

                @Override
                public void onFinish() {
                    textView.setText("FINISHED");
                    start.setEnabled(true);
                }
            };
        }
        countDownTimer.start();
    }
    private void cancel() {
        if (countDownTimer!=null){
            countDownTimer.cancel();
            textView.setText("00:00");
            countDownTimer=null;
            start.setEnabled(true);
        }
    }

}
