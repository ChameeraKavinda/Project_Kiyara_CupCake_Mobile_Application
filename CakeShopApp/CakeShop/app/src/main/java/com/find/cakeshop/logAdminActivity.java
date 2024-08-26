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

public class logAdminActivity extends AppCompatActivity {
    TextView txvName;
    EditText edtPin;
    Button btnLog;
    ImageButton ibtnlogout;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_admin_login);
        btnLog=findViewById (R.id.btnll);
        edtPin=findViewById (R.id.edt2);
        txvName=findViewById (R.id.edtn1);
        ibtnlogout=findViewById (R.id.ibtnlogout);
        // Set hardcoded default values
        String defaultUsername = "Admin";
        int defaultPin = 145;

        // Set the default values in the UI components
        txvName.setText(defaultUsername);
        SharedPreference preference= new SharedPreference();

        // Save the default values in SharedPreferences if not already saved
        if (preference.GetString(getApplicationContext(), SharedPreference.Key_Name) == null) {
            preference.SaveString(getApplicationContext(), defaultUsername, SharedPreference.Key_Name);
        }

        if (preference.GetInt(getApplicationContext(), SharedPreference.Key_Admin_PIN) == -1) {
            preference.SaveInt(getApplicationContext(), defaultPin, SharedPreference.Key_Admin_PIN);
        }
        String name= preference.GetString(getApplicationContext(),SharedPreference.Key_Name);
        btnLog.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                int Pin = preference.GetInt(getApplicationContext(),SharedPreference.Key_Admin_PIN);
                if (Integer.valueOf(edtPin.getText().toString()) == Pin) {
                    preference.SaveBoolean (getApplicationContext (),
                            true, SharedPreference.Key_Status);

                Intent intent = new Intent (getApplicationContext (),Admin_Option.class);
                Toast.makeText ( getApplicationContext (),"Admin Loging Succesful",Toast.LENGTH_LONG).show ();

                    startActivity (intent);
                    logAdminActivity.this.finish ();
                }
                else
                    Toast.makeText ( getApplicationContext (),"Incorrect Pin",Toast.LENGTH_LONG).show ();

            }

        });

        ibtnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preference.SaveBoolean(getApplicationContext(),false,SharedPreference.Key_Status);
                Intent intent= new Intent(getApplicationContext(), logActivity.class);
                startActivity(intent);
                logAdminActivity.this.finish();
            }
        });





    }
}
