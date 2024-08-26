package com.find.cakeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtEmail, edtPIN;
    Button btnReg, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPIN = findViewById(R.id.edtPass);
        btnReg = findViewById(R.id.btnReg);
        button2 = findViewById(R.id.button2);

        SharedPreference preference = new SharedPreference();
        String name = preference.GetString(getApplicationContext(), SharedPreference.Key_Name);
        boolean status = preference.GetBoolean(getApplicationContext(), SharedPreference.Key_Status);
        if (name != null) {
            if (status) {
                Intent intent = new Intent(getApplicationContext(), userCategory.class);
                startActivity(intent);
                this.finish();
            } else {
                Intent intent = new Intent(getApplicationContext(), logActivity.class);
                startActivity(intent);
                this.finish();
            }
        }

        edtPIN.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String password = edtPIN.getText().toString().trim();
                    if (!password.matches("[0-9]+")) {
                        Toast.makeText(getApplicationContext(), "Use only numbers for password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtName.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String password = edtPIN.getText().toString().trim();

                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (!password.matches("[0-9]+")) {
                    Toast.makeText(getApplicationContext(), "Use only numbers for password", Toast.LENGTH_SHORT).show();
                } else {
                    preference.SaveString(getApplicationContext(), username, SharedPreference.Key_Name);
                    preference.SaveString(getApplicationContext(), email, SharedPreference.Key_Email);
                    preference.SaveInt(getApplicationContext(), Integer.valueOf(password), SharedPreference.Key_PIN);
                    Intent intent = new Intent(getApplicationContext(), logActivity.class);
                    Toast.makeText(getApplicationContext(), "Register Successful", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), logActivity.class);
                startActivity(intent);
            }
        });
    }
}
