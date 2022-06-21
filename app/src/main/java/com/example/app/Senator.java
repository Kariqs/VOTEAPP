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

public class Senator extends AppCompatActivity  {
    Spinner sen_spinner;
    EditText sen_votes,sen_constituency,sen_ward,sen_ps;
    Button sen_post;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senator);



        sen_spinner = findViewById(R.id.sen_spinner);
        sen_votes = findViewById(R.id.sen_votes);
        sen_constituency = findViewById(R.id.sen_constituency);
        sen_ward = findViewById(R.id.sen_ward);
        sen_ps = findViewById(R.id.sen_ps);
        sen_post = findViewById(R.id.sen_post);
        databaseReference = FirebaseDatabase.getInstance().getReference();


        sen_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postSenatorResults();
            }
        });

        ArrayAdapter<CharSequence> senator = ArrayAdapter.createFromResource(this,R.array.Senator, android.R.layout.simple_spinner_item);
        senator.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sen_spinner.setAdapter(senator);

    }

    private void postSenatorResults() {
        String SENATOR,VOTES,CONSTITUENCY,WARD,POLLING_STATION,ID;
        SENATOR= sen_spinner.getSelectedItem().toString();
        VOTES = sen_votes.getText().toString();
        CONSTITUENCY = sen_constituency.getText().toString();
        WARD = sen_ward.getText().toString();
        POLLING_STATION = sen_ps.getText().toString();
        ID = databaseReference.push().getKey();

        SenatorHelper senatorHelper = new SenatorHelper(SENATOR,VOTES,CONSTITUENCY,WARD,POLLING_STATION);
        databaseReference.child("Senators").child(ID).setValue(senatorHelper);
        Toast.makeText(this, "POSTED SUCCESSFUL", Toast.LENGTH_SHORT).show();
        sen_votes.setText("");
        sen_constituency.setText("");
        sen_ward.setText("");
        sen_ps.setText("");


    }


}