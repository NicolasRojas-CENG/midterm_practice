package com.test;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;


public class date_screen extends AppCompatActivity /*implements DatePickerDialog.OnDateSetListener */{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_screen);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Date selector");
        Button goBack = findViewById(R.id.goBack);
        final DatePicker datePicker = findViewById(R.id.datePicker);
        Button setDate = findViewById(R.id.dateButton);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Going back.",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dateText = findViewById(R.id.dateText);
                dateText.setText(datePicker.getDayOfMonth()+"/"+datePicker.getMonth()+"/"+datePicker.getYear());
                //Toast.makeText(date_screen.this,datePicker.getDayOfMonth()+"/"+datePicker.getMonth()+"/"+datePicker.getYear(),Toast.LENGTH_LONG).show();
            }
        });

    }

    public static Intent makeDateIntent(Context context){
        return new Intent(context, date_screen.class);
    }

}
