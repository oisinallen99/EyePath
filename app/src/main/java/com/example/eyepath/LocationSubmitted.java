package com.example.eyepath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class LocationSubmitted extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_submitted);
        TextView textViewLocation = findViewById(R.id.textViewLocation3);
        String locationName = getIntent().getStringExtra("address");
        textViewLocation.setText(locationName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public void launchMaps(MenuItem item) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void logout(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void eyeGaze(MenuItem item) {
        Intent intent = new Intent(this, ConfigureEyeGaze.class);
        startActivity(intent);
    }
}