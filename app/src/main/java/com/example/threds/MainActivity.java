package com.example.threds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.count_number);



    }

    public void clearCount(View v){

        tv.setText("00");
    }

    public void startCount(View v){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<100; i++){
                    try {
                        Thread.sleep(1000);
                        int x=i;
                        Runnable r2= new Runnable() {
                            @Override
                            public void run() {
                                tv.setText(""+x);
                            }
                        };
                        runOnUiThread(r2);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}