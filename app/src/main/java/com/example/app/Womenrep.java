package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Womenrep extends AppCompatActivity  {
    Spinner w_spinner;
    EditText w_votes,w_constituency,w_ward,w_ps;
    Button w_post;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_womenrep);
        w_spinner = findViewById(R.id.w_spinner);
        w_votes= findViewById(R.id.w_votes);
        w_constituency = findViewById(R.id.w_constituency);
        w_ward = findViewById(R.id.w_ward);
        w_ps = findViewById(R.id.w_ps);
        w_post = findViewById(R.id.w_post);
        databaseReference= FirebaseDatabase.getInstance().getReference();

        ArrayAdapter<CharSequence> women_rep = ArrayAdapter.createFromResource(this, R.array.Women_rep, android.R.layout.simple_spinner_item);
        women_rep.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        w_spinner.setAdapter(women_rep);

        w_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postWrepResults();
            }
        });


    }

    private void postWrepResults() {
        String WOMEN_REP,VOTES,CONSTITUENCY,WARD,POLLING_STATION,ID;

        WOMEN_REP=w_spinner.getSelectedItem().toString();
        VOTES = w_votes.getText().toString();
        CONSTITUENCY = w_constituency.getText().toString();
        WARD = w_ward.getText().toString();
        POLLING_STATION= w_ps.getText().toString();
        ID = databaseReference.push().getKey();

        WrepHelper wrepHelper = new WrepHelper(WOMEN_REP,VOTES,CONSTITUENCY,WARD,POLLING_STATION);
        databaseReference.child("WomenRep").child(ID).setValue(wrepHelper);
        Toast.makeText(this, "POSTED SUCCESSFUL", Toast.LENGTH_SHORT).show();
        w_votes.setText("");
        w_constituency.setText("");
        w_ward.setText("");
        w_ps.setText("");


    }
}