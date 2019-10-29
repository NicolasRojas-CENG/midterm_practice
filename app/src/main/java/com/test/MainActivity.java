package com.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity{

    private static final int REQUEST_CODE = 2000;
    private Menu menu;
    private boolean mclicked = false;
    Toolbar mToolbar;
    FloatingActionButton mFab;
    FloatingActionButton mFab1;
    EditText mediText2;
    TextView mtextView;

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

    mFab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });

    }
}

