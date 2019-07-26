package com.ldh.android.easygame;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.zip.Inflater;

public class MainActivity extends Activity {

    Button play;
    TextView point;

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, PlayActivity.class);
                startActivity(intent);
            }
        });

    }


    private void mapping() {
        play = (Button) findViewById(R.id.Button_play);
        point = (TextView) findViewById(R.id.TextView_point);

    }

}
