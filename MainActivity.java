package com.example.root.service_demo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_start, btn_stop;
    Handler handler=null;
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
            handler.postDelayed(runnable,5000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = (Button)findViewById(R.id.btn_start);
        btn_stop = (Button)findViewById(R.id.btn_stop);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(handler == null){
                    handler = new Handler();
                    handler.postDelayed(runnable, 1000);
                }

            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(handler!=null){
                    handler.removeCallbacks(runnable);
                    handler=null;
                }

            }
        });
    }
}
