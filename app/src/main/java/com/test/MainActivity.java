package com.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity{

FloatingActionButton actionButtonMail;
FloatingActionButton actionButtonAlert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionButtonMail = findViewById(R.id.fab);
        actionButtonMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Do you want to send message?", Snackbar.LENGTH_LONG)
                        .setAction("TEXT", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                email();
                            }
                        }).show();
            }
        });

        actionButtonAlert = findViewById(R.id.fab1);
        actionButtonAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Alert Dialog.").setMessage("This is an alert message.")
                        .setIcon(R.drawable.ic_warning)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create();
                dialog.show();
            }
        });

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

    private void email(){

        try{
            String message = "hello";
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, message);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }catch (SecurityException error)
        {
            Log.e("MapleLeaf", "Call Failed");
        }
    }

}

