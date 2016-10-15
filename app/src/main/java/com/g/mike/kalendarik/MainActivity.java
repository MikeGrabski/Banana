package com.g.mike.kalendarik;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


/**
 * The launcher activity of the sample app. It contains the links to visit all the example screens.
 * Created by Raquib-ul-Alam Kanak on 7/21/2014.
 * Website: http://alamkanak.github.io
 */
public class MainActivity extends
        Activity {

    Calendar calendar;
    // DatePicker datePicker;
    DatePickerDialog datePickerDialog;
    CalendarView mCalendarView;
    long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        datePicker = (DatePicker)findViewById(R.id.datePiceker);

//        calendar = (CalendarView)findViewById(R.id.calendar);
//        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
//            }
//        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        calendar = Calendar.getInstance();
//        time = setCurrentDate();
//        datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
//
//            }
//        }, calendar.getTime().getYear(),Calendar.MONTH-1,Calendar.DAY_OF_MONTH-1);

        datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            }
        }, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
//        mCalendarView.setDate(time, true, true);

    }


//    long setCurrentDate() {
//        long time= System.currentTimeMillis();
//        return time;
//    }
}
