package com.example.mart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LauncherActivity1 extends AppCompatActivity {
    String Email,Password;
    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher1);

        Button login = (Button) findViewById(R.id.login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);


            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Email = email.getText().toString();
                    Password = password.getText().toString();
                    Toast.makeText(getApplicationContext(), Email, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), Password, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LauncherActivity1.this, MainActivity.class));
                    finish();

                    if (Email.equals("") && Password.equals(""))
                    {
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    }
                    else
                        {
                        Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }

                }
            });


    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }

}