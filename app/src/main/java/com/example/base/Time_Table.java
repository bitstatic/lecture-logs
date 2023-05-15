package com.example.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Time_Table extends AppCompatActivity {

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
        String[] years = new String[]{"1st Year", "2nd Year", "3rd Year", "4rth Year"};
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, years);
        yearDropdown.setAdapter(yearAdapter);

//        Batch select
        Spinner batchDropdown = findViewById(R.id.batch);
        String[] batches = new String[]{"b1", "b2", "b3"};
        ArrayAdapter<String> batchAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, batches);
        batchDropdown.setAdapter(batchAdapter);

//        specialization select
        Spinner specDropdown = findViewById(R.id.spec);
        String[] options = new String[]{"No Specialization", "Specialization"};
        ArrayAdapter<String> specAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, options);
        specDropdown.setAdapter(specAdapter);

    }
}