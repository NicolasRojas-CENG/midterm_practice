package com.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button test = findViewById(R.id.button1);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Going to main screen.", Toast.LENGTH_LONG).show();
                //Intent mainScreenIntent = new Intent(MainActivity.this, main_screen.class);
                Intent mainScreenIntent = main_screen.makeIntent(MainActivity.this);
                startActivity(mainScreenIntent);
            }
        });



    }
}

