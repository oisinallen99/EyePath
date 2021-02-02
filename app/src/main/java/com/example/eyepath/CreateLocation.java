package com.example.eyepath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateLocation extends AppCompatActivity {
    
    String locationName;
    String name;
    float rating;
    String review;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("Savedlocations");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_location);
        TextView textViewLocation = findViewById(R.id.textViewLocation2);
        locationName = getIntent().getStringExtra("address");
        textViewLocation.setText(locationName);
    }

    public void create(View view) {
        EditText editTextName = findViewById(R.id.editTextTextPersonName3);
        RatingBar rBar = findViewById(R.id.rBar);
        EditText editTextReview = findViewById(R.id.editTextReview);
        name = editTextName.getText().toString();
        locationName = getIntent().getStringExtra("address");
        rating = rBar.getRating();
        review = editTextReview.getText().toString();
        DatabaseReference locationsRef = ref.child("locations");
        locationsRef.child(name).setValue(new Location(locationName, rating, review));
        Intent intent = new Intent(getApplicationContext(), LocationSubmitted.class);
        intent.putExtra("address", locationName);
        startActivity(intent);
    }
}