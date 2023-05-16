package com.example.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.Spinner;
import android.widget.TextView;

public class Time_Table extends AppCompatActivity {
    //  data[year][day][batch][time]
    String[][][][] data = {
            {{{}}},
            {
                    {
                            {"AI", null, "APS", "CDM", null, "OS", null, null},
                            {"CN", "AI", "AI Lab", null, "OS", null, null, null}
                    },
                    {
                            {"CN", "AI", "AI Lab", null, "OS", null, null, null},
                            {"AI", null, "APS", "CDM", null, "OS", null, null}
                    }
            }
    };
    int day=0;

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

        Spinner dayDropdown = findViewById(R.id.day);
        String[] days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        ArrayAdapter<String> dayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, days);
        dayDropdown.setAdapter(dayAdapter);

//        specialization select
        Spinner specDropdown = findViewById(R.id.spec);
        String[] options = new String[]{"No Specialization", "Specialization"};
        ArrayAdapter<String> specAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, options);
        specDropdown.setAdapter(specAdapter);

//        String weekDay;
//        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
//
//        Calendar calendar = Calendar.getInstance();
//        weekDay = dayFormat.format(calendar.getTime());
////        System.out.println(weekDay);
//
//        LinearLayout weekdayLayout = findViewById(R.id.weekdays);
//        for (int i = 0; i < weekdayLayout.getChildCount(); i += 2) {
//            TextView day = (TextView) weekdayLayout.getChildAt(i);
//            String brooo = day.getText().toString();
//            System.out.println(brooo);
//            if (brooo.equals(weekDay))
//                day.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_corners));
//        }


//        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout ltime = findViewById(R.id.lineartime);
//
//        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout lclass = findViewById(R.id.linearclass);
//
//        List<List<Pair<String, String>>> data;


    }

    public void setData(View view) {
        Spinner yearSpinner = (Spinner) findViewById(R.id.year);
        Spinner batchSpinner = (Spinner) findViewById(R.id.batch);
        Spinner specSpinner = (Spinner) findViewById(R.id.spec);
        Spinner daySpinner = (Spinner) findViewById(R.id.day);
        String year = yearSpinner.getSelectedItem().toString();
        String batch = batchSpinner.getSelectedItem().toString();
        String spec = specSpinner.getSelectedItem().toString();
        String weekDay = daySpinner.getSelectedItem().toString();
        int y = 0, b = 0, day=0;
        boolean sp;
        if (year == "1st Year") y = 0;
        else if (year == "2nd Year") y = 1;
        else if (year == "3rd Year") y = 2;
        else if (year == "4th Year") y = 3;

        if (batch == "B1") b = 0;
        else if (batch == "B2") b = 1;
        else if (batch == "B3") b = 2;

        if (weekDay=="Monday") day=0;
        else if (weekDay=="Tuesday") day=1;
        else if (weekDay=="Wednesday") day=2;
        else if (weekDay=="Thursday") day=3;
        else if (weekDay=="Friday") day=4;
        else if (weekDay=="Saturday") day=5;

        if (spec == "No Specialization") sp = false;
        else sp = true;

        TextView t9 = (TextView) findViewById(R.id.time_9);
        t9.setText(data[y][day][b][0]);
        TextView t10 = (TextView) findViewById(R.id.time_10);
        TextView t11 = (TextView) findViewById(R.id.time_11);
        TextView t12 = (TextView) findViewById(R.id.time_12);
        TextView t2 = (TextView) findViewById(R.id.time_2);
        TextView t3 = (TextView) findViewById(R.id.time_3);
        TextView t4 = (TextView) findViewById(R.id.time_4);
        TextView t5 = (TextView) findViewById(R.id.time_5);

        for (int i = 0; i < 8; i++) {
            switch (i) {
                case (0):
                    t9.setVisibility(View.VISIBLE);
                    break;
                case (1):
                    t10.setVisibility(View.VISIBLE);
                    break;
                case (2):
                    t11.setVisibility(View.VISIBLE);
                    break;
                case (3):
                    t12.setVisibility(View.VISIBLE);
                    break;
                case (4):
                    t2.setVisibility(View.VISIBLE);
                    break;
                case (5):
                    t3.setVisibility(View.VISIBLE);
                    break;
                case (6):
                    t4.setVisibility(View.VISIBLE);
                    break;
                case (7):
                    t5.setVisibility(View.VISIBLE);
                    break;

            }
        }
        for (int i = 0; i < 8; i++) {
            String s = data[y][day][b][i];
            if (s != null) {
                switch (i) {
                    case (0):
                        t9.setText(data[y][day][b][i]);
                        break;
                    case (1):
                        t10.setText(data[y][day][b][i]);
                        break;
                    case (2):
                        t11.setText(data[y][day][b][i]);
                        break;
                    case (3):
                        t12.setText(data[y][day][b][i]);
                        break;
                    case (4):
                        t2.setText(data[y][day][b][i]);
                        break;
                    case (5):
                        t3.setText(data[y][day][b][i]);
                        break;
                    case (6):
                        t4.setText(data[y][day][b][i]);
                        break;
                    case (7):
                        t5.setText(data[y][day][b][i]);
                        break;
                }

            } else {
                switch (i) {
                    case (0):
                        t9.setVisibility(View.INVISIBLE);
                        break;
                    case (1):
                        t10.setVisibility(View.INVISIBLE);
                        break;
                    case (2):
                        t11.setVisibility(View.INVISIBLE);
                        break;
                    case (3):
                        t12.setVisibility(View.INVISIBLE);
                        break;
                    case (4):
                        t2.setVisibility(View.INVISIBLE);
                        break;
                    case (5):
                        t3.setVisibility(View.INVISIBLE);
                        break;
                    case (6):
                        t4.setVisibility(View.INVISIBLE);
                        break;
                    case (7):
                        t5.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        }
    }
}