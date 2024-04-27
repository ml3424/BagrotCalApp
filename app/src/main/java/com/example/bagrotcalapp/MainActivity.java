package com.example.bagrotcalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toast toast;
    Button nextBtn;
    EditText eTname, eTlanguage, eTliterature, eThistory, eTnationality, eTbible;

    String nameG;
    int languageG, literatureG, historyG, nationalityG, bibleG;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTname = findViewById(R.id.eTname);
        eTlanguage = findViewById(R.id.eTlanguage);
        eTliterature = findViewById(R.id.eTliterature);
        eThistory = findViewById(R.id.eThistory);
        eTnationality = findViewById(R.id.eTnationality);
        eTbible = findViewById(R.id.eTbible);
    }

    boolean checkInputGrade(int input)
    {
        if(input > 101)
        {
            toast = Toast.makeText(getApplicationContext(),"grade is a number between 1-100. try again",Toast.LENGTH_SHORT);
            return false;
        }
        return true;
    }

    public void nextScreen(View view) {
        // get valid grades from the editexts and the user name.
        nameG = eTname.getText().toString();

        do {
            languageG = Integer.valueOf(eTlanguage.getText().toString());
        } while(checkInputGrade(languageG));
        do {
            literatureG = Integer.valueOf(eTliterature.getText().toString());
        } while(checkInputGrade(literatureG));
        do {
            historyG = Integer.valueOf(eThistory.getText().toString());
        } while(checkInputGrade(historyG));
        do {
            nationalityG = Integer.valueOf(eTnationality.getText().toString());
        } while(checkInputGrade(nationalityG));
        do {
            bibleG = Integer.valueOf(eTbible.getText().toString());
        } while(checkInputGrade(bibleG));




    }
}