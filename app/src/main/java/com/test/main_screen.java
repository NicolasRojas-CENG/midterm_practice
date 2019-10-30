package com.test;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

public class main_screen extends AppCompatActivity {

    RelativeLayout view2;
    Switch switch1;
    //TextView text1;
    //private int mCounter = 0;
    Button sleep;
    Button quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Main screen");
        Button goBack =findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Going back.",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        switch1 = findViewById(R.id.switch1);
        view2 = findViewById(R.id.view2);
        switch1.setChecked(true);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(getApplicationContext(),"Switch on.", Toast.LENGTH_LONG).show();
                    view2.setVisibility(View.VISIBLE);
                    generateButton();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Switch off.", Toast.LENGTH_LONG).show();
                    view2.setVisibility(View.INVISIBLE);
                }
            }
        });

        Button date = findViewById(R.id.dateButton);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Going to date screen.",Toast.LENGTH_SHORT).show();
                Intent dateScreenIntent = date_screen.makeDateIntent(main_screen.this);
                startActivity(dateScreenIntent);
            }
        });

        //text1 = findViewById(R.id.textView);
        //recordMethod("onCreate Called");
        sleep = findViewById(R.id.sleepButton);
        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_screen.super.onStop();
            }
        });
        quit = findViewById(R.id.quitButton);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_screen.super.onStop();
                main_screen.super.onDestroy();
            }
        });
    }

    private void generateButton() {

        Button myButton = new Button(this);
        // parms is used to set parameters.
        RelativeLayout.LayoutParams params =  new RelativeLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(100,250,100,250);
        // myButton.setId(R.id.idReset);
        myButton.setBackgroundColor(Color.YELLOW);
        myButton.setText("Reset switch");
        myButton.setLayoutParams(params);
        view2.addView(myButton, params); // Add button to the layout.

        // add button click event.
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch1.setChecked(false);
            }
        });
    }

    /*private void recordMethod(String str){
        //Attach a time stamp.
        long time = (long) (System.currentTimeMillis());
        Timestamp tsTemp = new Timestamp(time);
        String tstr =  tsTemp.toString();
        text1.append(str + " at: \n" + tstr + "\n\n");

        Log.d("MapleLeaf", str + " at: " + tstr);
        // Just as an indicator, not really used to calculate any values.
        mCounter = mCounter + 1;

        // Set view1 to indicate the local variable status.
        TextView view1 = findViewById(R.id.textView2);
        view1.setText("The Local Value mCounter is: " + mCounter);
    }*/

    public static Intent makeIntent(Context context){
        return new Intent(context, main_screen.class);
    }

}

