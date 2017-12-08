package com.aavdeev.tamato;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int min;
    private boolean runing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runTime();
    }

    public void onClickStart(View view) {
        runing = true;

    }

    public void onClickStop(View view) {
        runing = false;
    }

    public void onClickReset(View view) {
        runing = false;
        min = 0;
    }

    private void runTime() {
        final TextView textView = (TextView) findViewById(R.id.time);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int minuts = (min % 3600) / 60;
                int seconds = min % 60;

                String time = String.format("%02d:%02d", minuts, seconds);
                textView.setText(time);
                if (runing) {
                    min++;
                    if (min == 2) {
                        runing = false;
                    }
                }


                 handler.postDelayed(this, 1000);
            }
        });

    }
}
