package com.find.cakeshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class logActivity extends AppCompatActivity {
    TextView txvName;
    EditText edtPin;
    Button btnLog,btn12;
    ImageButton preReg;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login);
        btnLog=findViewById (R.id.btnLog);
        edtPin=findViewById (R.id.edtPass);
        txvName=findViewById (R.id.edtName);
        btn12=findViewById (R.id.btn12);
        preReg = findViewById (R.id.preReg);
        SharedPreference preference= new SharedPreference();
        String name= preference.GetString(getApplicationContext(),SharedPreference.Key_Name);
        btnLog.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                int Pin = preference.GetInt(getApplicationContext(),SharedPreference.Key_PIN);
                if(Integer.valueOf(edtPin.getText().toString()) == Pin)
                {
                    preference.SaveBoolean(getApplicationContext(),
                            true,SharedPreference.Key_Status);
                    Intent intent= new Intent(getApplicationContext(), Option.class);
                    Toast.makeText ( getApplicationContext (),"Loging Succesful",Toast.LENGTH_LONG).show ();

                    startActivity(intent);
                    logActivity.this.finish();
                }
                else
                    Toast.makeText ( getApplicationContext (),"Invalid User name or Password",Toast.LENGTH_LONG).show ();

            }

        });
        btn12.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext (),logAdminActivity.class);
                startActivity (intent);

            }
        });
        preReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preference.SaveBoolean(getApplicationContext(),false,SharedPreference.Key_Status);
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                logActivity.this.finish();
            }
        });






    }
}
