package com.g.mike.kalendarik;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.g.mike.kalendarik.Data.Question;
import com.g.mike.kalendarik.Data.Questions365;

import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    Calendar calendar;
    Toolbar toolbar;
    // DatePicker datePicker;
    DatePickerDialog datePickerDialog;


    //for demo
    TextView textQuestion;
    EditText answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textQuestion = (TextView)findViewById(R.id.questionText);
        answer = (EditText) findViewById(R.id.answer1) ;
        calendar = Calendar.getInstance();
        goToDate(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                goToDate(i,i1,i2);
            }
        }, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));


    }

    @Override
    protected void onStart() {
        super.onStart();
        pickADate(null);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    private void goToDate(int year, int month, int day){
        calendar.set(year,month,day);
        textQuestion.setText(Questions365.getQuestions('e')[(calendar.get(Calendar.DAY_OF_YEAR)-1)%365]);//crash on 365 :o
        answer.setText("2016" + "Answer to question number  " + calendar.get(Calendar.DAY_OF_YEAR) + "  Eeeeva you so cute :3");
    }


    public void pickADate(@Nullable MenuItem item) {
        datePickerDialog.show();
    }
}
