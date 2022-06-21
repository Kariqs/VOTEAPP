package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Agent extends AppCompatActivity {
      Button governor,senator,wrep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_agent);

        governor = findViewById(R.id.governor);
        senator= findViewById(R.id.senator);
        wrep = findViewById(R.id.wrep);

       governor.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Agent.this,Governor.class);
               startActivity(intent);
           }
       });
       senator.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent inte = new Intent(Agent.this, Senator.class);
               startActivity(inte);
           }
       });
       wrep.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(Agent.this,Womenrep.class);
               startActivity(i);
           }
       });
    }
}