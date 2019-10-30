package com.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.item1:
                finishAndRemoveTask();
                return true;

            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Selected item2.", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Selected item3.", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.submenuitem1:
                Toast.makeText(getApplicationContext(), "Going to main screen.", Toast.LENGTH_LONG).show();
                //Intent mainScreenIntent = new Intent(MainActivity.this, main_screen.class);
                Intent mainScreenIntent = main_screen.makeIntent(MainActivity.this);
                startActivity(mainScreenIntent);
                return true;

            case R.id.submenuitem2:
                Toast.makeText(getApplicationContext(), "Exiting app.", Toast.LENGTH_SHORT).show();
                finishAndRemoveTask();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

