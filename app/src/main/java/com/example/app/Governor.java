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

public class Governor extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner gov_spinner;
    EditText gov_votes,gov_constituency,gov_ward,gov_ps;
    Button gov_post;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_governor);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        gov_spinner = findViewById(R.id.gov_spinner);
        gov_votes = findViewById(R.id.gov_votes);
        gov_constituency = findViewById(R.id.gov_constituency);
        gov_ward = findViewById(R.id.gov_ward);
        gov_ps = findViewById(R.id.gov_ps);
        gov_post= findViewById(R.id.gov_post);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        gov_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postGovernorResults();
            }
        });

        ArrayAdapter<CharSequence> governor = ArrayAdapter.createFromResource(this,R.array.Governor, android.R.layout.simple_spinner_item);
        governor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gov_spinner.setAdapter(governor);

        gov_spinner.setOnItemSelectedListener(this);
    }

    private void postGovernorResults() {
       String GOVERNOR,G_VOTES,G_CONSTITUENCY,G_WARD,G_PS, ID ;
       GOVERNOR = gov_spinner.getSelectedItem().toString();
       G_VOTES = gov_votes.getText().toString();
       G_CONSTITUENCY = gov_constituency.getText().toString();
       G_WARD = gov_ward.getText().toString();
       G_PS = gov_ps.getText().toString();
       ID = databaseReference.push().getKey();

       UserHelper userHelper = new UserHelper(GOVERNOR,G_VOTES,G_CONSTITUENCY,G_WARD,G_PS);
       databaseReference.child("Governors").child(ID).setValue(userHelper);
        Toast.makeText(this, "POSTED SUCCESSFUL", Toast.LENGTH_SHORT).show();
        gov_votes.setText("");
        gov_constituency.setText("");
        gov_ward.setText("");
        gov_ps.setText("");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(),choice,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}