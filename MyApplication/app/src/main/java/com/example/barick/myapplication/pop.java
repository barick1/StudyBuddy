package com.example.barick.myapplication;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Vibrator;

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
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(250);
        String text = editText.getText().toString();
        if(text.isEmpty()==true){

        }else {
            int seconds = 60 * Integer.valueOf(text);
            if (seconds != 0) {
                countDownTimer = new CountDownTimer(seconds * 1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        long minute = millisUntilFinished / 60000;
                        long temp = millisUntilFinished / 1000;
                        long second = temp % 60;
                        if (second < 10) {
                            textView.setText(minute + ":0" + second);
                        } else {
                            textView.setText(minute + ":" + second);
                        }
                        start.setEnabled(false);
                    }

                    @Override
                    public void onFinish() {
                        textView.setText("FINISHED");
                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        // Vibrate for 500 milliseconds
                        v.vibrate(500);
                        start.setEnabled(true);
                    }
                };
            }
            countDownTimer.start();
        }
    }
    private void cancel() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(250);
        if (countDownTimer!=null){
            editText.setText("");
            countDownTimer.cancel();
            textView.setText("00:00");
            countDownTimer=null;
            start.setEnabled(true);
        }
    }


}
