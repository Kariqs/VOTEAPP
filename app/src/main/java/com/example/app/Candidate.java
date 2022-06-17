package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Candidate extends AppCompatActivity {

    Button Governor,Senator,Women_rep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);
        Governor = findViewById(R.id.GOV);
        Senator = findViewById(R.id.SEN);
        Women_rep = findViewById(R.id.WREP);

        Governor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Candidate.this,GRecycle.class);
                startActivity(i);
            }
        });
    }
}