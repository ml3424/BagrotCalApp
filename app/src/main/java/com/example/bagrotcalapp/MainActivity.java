package com.example.bagrotcalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    boolean checkInput(String input)
    {
        if(Integer.valueOf(input) > 101)
        {
            toast = Toast.makeText(getApplicationContext(),"grade is a number between 1-100. try again",Toast.LENGTH_SHORT);
            return false;
        }
        return true;
    }

    public void nextScreen(View view) {
    }
}