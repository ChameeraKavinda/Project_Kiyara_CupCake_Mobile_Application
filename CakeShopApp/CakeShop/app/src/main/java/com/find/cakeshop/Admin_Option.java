package com.find.cakeshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Admin_Option extends AppCompatActivity {
    Button btncat,btncake,btnorder;
    ImageButton prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_admin_option);



        btncat=findViewById (R.id.btnCategarory);
        btncake=findViewById (R.id.btncake);
        btnorder=findViewById (R.id.btnorder);
        prev=findViewById (R.id.prev);




            SharedPreference preference= new SharedPreference();
            String name= preference.GetString(getApplicationContext(),SharedPreference.Key_Name);
        prev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    preference.SaveBoolean(getApplicationContext(),false,SharedPreference.Key_Status);
                    Intent intent= new Intent(getApplicationContext(), logActivity.class);
                    startActivity(intent);
                    Admin_Option.this.finish();
                }
            });
        btncat.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext (),CategoryActivity.class);
                startActivity (intent);
            }
        });
        btncake.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext (), adminCategory.class);
                startActivity (intent);
            }
        });
        btnorder.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext (),OrderActivity.class);
                startActivity (intent);
            }
        });
    }
}