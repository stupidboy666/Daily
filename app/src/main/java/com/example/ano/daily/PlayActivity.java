package com.example.ano.daily;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.litepal.LitePal;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //init the LitePal
        LitePal.initialize(this);
    }

    protected void onResume()
    {
        super.onResume();

    }
}
