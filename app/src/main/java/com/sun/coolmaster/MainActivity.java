package com.sun.coolmaster;

import android.app.Activity;
import android.os.Bundle;

import coolmaster.sun.com.gy904.gy906;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new gy906("");
    }
}
