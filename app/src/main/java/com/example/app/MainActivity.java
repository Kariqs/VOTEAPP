package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView email,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email);
        password=findViewById(R.id.passsword);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("agent@iebc.ac.ke")&& password.getText().toString().equals("12345678")){
                    Intent i = new Intent(MainActivity.this, Agent.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    email.setText("");
                    password.setText("");
                }else if (email.getText().toString().equals("governor@iebc.ac.ke")&& password.getText().toString().equals("12345")){
                    Intent i = new Intent(MainActivity.this, GRecycle.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    email.setText("");
                    password.setText("");
                }
                else if (email.getText().toString().equals("senator@iebc.ac.ke")&& password.getText().toString().equals("12345")){
                    Intent i = new Intent(MainActivity.this, Srecycle.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    email.setText("");
                    password.setText("");
                }
                else if (email.getText().toString().equals("womenrep@iebc.ac.ke")&& password.getText().toString().equals("12345")){
                    Intent i = new Intent(MainActivity.this, Wrecycle.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    email.setText("");
                    password.setText("");
                }
                else{
                    email.setText("");
                    password.setText("");
                    Toast.makeText(MainActivity.this, "Please enter correct login credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}