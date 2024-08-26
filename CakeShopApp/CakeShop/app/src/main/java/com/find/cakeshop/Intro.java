package com.find.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Intro extends AppCompatActivity {
    ImageButton ibtnIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_intro);

        ibtnIntro.findViewById (R.id.ibtnIntro);
        ibtnIntro.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (getApplicationContext (),MainActivity.class);
                startActivity (intent);
            }
        });
    }
}