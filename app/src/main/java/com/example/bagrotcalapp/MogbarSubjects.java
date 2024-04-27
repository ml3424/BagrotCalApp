package com.example.bagrotcalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MogbarSubjects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mogbar_subjects);

        Intent gi = getIntent();
        String nameG = gi.getStringExtra("nameG");
        int languageG = gi.getIntExtra("languageG",222);
        int literatureG = gi.getIntExtra("literatureG",222);
        int historyG = gi.getIntExtra("historyG",222);
        int nationalityG = gi.getIntExtra("nationalityG",222);
        int bibleG = gi.getIntExtra("bibleG",222);
    }

    public void firstScreen(View view) {
        finish();
    }
}