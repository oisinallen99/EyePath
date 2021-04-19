package com.example.eyepath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class WeekChart extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_chart);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        BarChart barChart = findViewById(R.id.barChart);

        ArrayList<BarEntry> activities = new ArrayList<>();
        activities.add(new BarEntry(19, 3));
        activities.add(new BarEntry(18, 1));
        activities.add(new BarEntry(17, 0));
        activities.add(new BarEntry(16, 0));
        activities.add(new BarEntry(15, 0));
        activities.add(new BarEntry(14, 0));
        activities.add(new BarEntry(13, 0));

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

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public void logout(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}