package com.example.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Time_Table extends AppCompatActivity {

    public void show(View view){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

//        Spinner yearSpinner = (Spinner) findViewById(R.id.year);
//        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(Time_Table.this,
//                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
//        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

//        year select
        Spinner yearDropdown = findViewById(R.id.year);
        String[] years = new String[]{"1st Year", "2nd Year", "3rd Year", "4th Year"};
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, years);
        yearDropdown.setAdapter(yearAdapter);

//        Batch select
        Spinner batchDropdown = findViewById(R.id.batch);
        String[] batches = new String[]{"B1", "B2", "B3"};
        ArrayAdapter<String> batchAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, batches);
        batchDropdown.setAdapter(batchAdapter);

//        specialization select
        Spinner specDropdown = findViewById(R.id.spec);
        String[] options = new String[]{"No Specialization", "Specialization"};
        ArrayAdapter<String> specAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, options);
        specDropdown.setAdapter(specAdapter);

        String weekDay;
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());

        Calendar calendar = Calendar.getInstance();
        weekDay = dayFormat.format(calendar.getTime());
//        System.out.println(weekDay);

        LinearLayout weekdayLayout = findViewById(R.id.weekdays);
        for(int i = 0; i < weekdayLayout.getChildCount(); i+=2){
            TextView day = (TextView) weekdayLayout.getChildAt(i);
            String brooo = day.getText().toString();
            System.out.println(brooo);
            if(brooo.equals(weekDay)) day.setBackground(ContextCompat.getDrawable(this,R.drawable.rounded_corners));
        }


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout ltime = findViewById(R.id.lineartime);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout lclass = findViewById(R.id.linearclass);

        List<List<Pair<String, String>>> data;










    }
}