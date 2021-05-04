package com.example.eyepath;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.BarChart;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

public class WeekChart extends AppCompatActivity {

    ArrayList<String> myTimestamps= new ArrayList<String>();
    ArrayList<Integer> dates= new ArrayList<>();
    CompletedActivity item = new CompletedActivity();

    private Toolbar toolbar;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_chart);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();

        addTimestamps();

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public void addTimestamps(){
        mUser = mAuth.getCurrentUser();
        String userID = mUser.getUid();

        DatabaseReference fireDB = FirebaseDatabase.getInstance().getReference("CompletedActivity");
        fireDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()){
                    item = data.getValue(CompletedActivity.class);
                    if(item.getUserID().equals(userID)){
                        myTimestamps.add(item.getTimestamp());
                    }
                }
                for(String ts: myTimestamps){
                    Long tsLong = Long.valueOf(ts).longValue();
                    Timestamp timestamp = new Timestamp(tsLong);
                    int date = timestamp.getDate();
                    dates.add(date);
                }
                createBarChart();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void createBarChart(){

        BarChart barChart = findViewById(R.id.barChart);

        int count1= Collections.frequency(dates, 29);
        int count2= Collections.frequency(dates, 30);
        int count3= Collections.frequency(dates, 1);
        int count4= Collections.frequency(dates, 2);
        int count5= Collections.frequency(dates, 3);
        int count6= Collections.frequency(dates, 4);
        int count7= Collections.frequency(dates, 5);

        ArrayList<BarEntry> activities = new ArrayList<>();
        activities.add(new BarEntry(29, count1));
        activities.add(new BarEntry(30, count2));
        activities.add(new BarEntry(1, count3));
        activities.add(new BarEntry(2, count4));
        activities.add(new BarEntry(3, count5));
        activities.add(new BarEntry(4, count6));
        activities.add(new BarEntry(5, count7));

        BarDataSet barDataSet = new BarDataSet(activities, "Completed Activities");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("");
        barChart.animateY(3000);

    }

    public void info(MenuItem item) {
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }

    public void refresh(MenuItem item) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void logout(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
