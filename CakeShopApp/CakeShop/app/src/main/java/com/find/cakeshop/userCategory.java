package com.find.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class userCategory extends AppCompatActivity {
    ImageButton btnCup,btnBrith,btnannevesery,btnValentine,btnGraduation,btnOthers,cart,acc;
    Button btnlgout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activty_user_category);
        btnCup=findViewById (R.id.btnCup);
        btnBrith=findViewById (R.id.btnBirth);
        btnlgout=findViewById (R.id.btnLogout);
        btnannevesery=findViewById (R.id.btnAns);
        btnGraduation=findViewById (R.id.btnGrad);
        btnValentine=findViewById (R.id.btnVal);

        btnOthers=findViewById (R.id.btnOth);
        cart=findViewById (R.id.cart);
        acc=findViewById (R.id.acc);

        SharedPreference preference= new SharedPreference();
        String name= preference.GetString(getApplicationContext(),SharedPreference.Key_Name);
        btnlgout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preference.SaveBoolean(getApplicationContext(),false,SharedPreference.Key_Status);
                Intent intent= new Intent(getApplicationContext(), logActivity.class);
                startActivity(intent);
                userCategory.this.finish();
            }
        });
        btnCup.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), CakeViewActivity.class);
                startActivity(intent);

            }

        });

//        btnCup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean isAdmin = true; // Replace this with your condition to check if it's an admin
//
//                Intent intent;
//                if (isAdmin) {
//                    // If it's an admin, go to CakeAdapterActivity
//                    intent = new Intent(getApplicationContext(), CakeActivity.class);
//                } else {
//                    // If it's a regular user, go to CakeViewActivity
//                    intent = new Intent(getApplicationContext(), CakeViewActivity.class);
//                }
//
//                startActivity(intent);
//            }
//        });
        btnBrith.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), CakeViewActivity.class);
                startActivity(intent);

            }
        });
        btnannevesery.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext (),CakeViewActivity.class);
                startActivity (intent);
            }
        });
        btnValentine.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext (),CakeViewActivity.class);
                startActivity (intent);
            }
        });
        btnGraduation.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext (),CakeViewActivity.class);
                startActivity (intent);
            }
        });
        btnOthers.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext (),CakeViewActivity.class);
                startActivity (intent);
            }
        });
        cart.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext (),CakeViewActivity.class);
                startActivity (intent);
            }
        });
        acc.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext (),logActivity.class);
                startActivity (intent);
            }
        });


    }
}