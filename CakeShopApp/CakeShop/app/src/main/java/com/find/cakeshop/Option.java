package com.find.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Option extends AppCompatActivity {
    Button btncat,btncake,btnorder;
    ImageButton prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_option);



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
                    Option.this.finish();
                }
            });
        btncat.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext (),CategoryView.class);
                Toast.makeText(getApplicationContext(), "Successfully Category View ", Toast.LENGTH_LONG).show();

                startActivity (intent);
            }
        });
        btncake.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext (), userCategory.class);
                Toast.makeText(getApplicationContext(), "Successfully Cake View ", Toast.LENGTH_LONG).show();

                startActivity (intent);
            }
        });
        btnorder.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext (),UserOrderView.class);
                startActivity (intent);
            }
        });
    }
}