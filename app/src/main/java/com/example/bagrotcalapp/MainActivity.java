package com.example.bagrotcalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button nextBtn;
    EditText eTname, eTlanguage, eTliterature, eThistory, eTnationality, eTbible;

    String name;
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

        nextBtn = findViewById(R.id.nextBtn);
    }

    boolean checkInputGrade(int input)
    {
        if(input > 100)
        {
            //Toast.makeText(getApplicationContext(),"grade is a number between 1-100. try again",Toast.LENGTH_SHORT);
            return false;
        }
        return true;
    }

    public boolean checkEmpty(String input)
    {
        if(input.isEmpty())
        {
            return true;
        }
        return false;
    }

    public void nextScreen(View view) {
        // get valid grades from the editexts and the user name.
        boolean notEmpty = true;

        name = eTname.getText().toString();
        if(checkEmpty(eTlanguage.getText().toString()) || checkEmpty(eTliterature.getText().toString()) || checkEmpty(eThistory.getText().toString()) || checkEmpty(eTnationality.getText().toString()) || checkEmpty(eTbible.getText().toString()))
        {
            notEmpty = false;
            Toast.makeText(getApplicationContext(),"One or more is empty. try again",Toast.LENGTH_SHORT).show();
        }
        else
        {
            languageG = Integer.valueOf(eTlanguage.getText().toString());
            literatureG = Integer.valueOf(eTliterature.getText().toString());
            historyG = Integer.valueOf(eThistory.getText().toString());
            nationalityG = Integer.valueOf(eTnationality.getText().toString());
            bibleG = Integer.valueOf(eTbible.getText().toString());
        }

        if(checkInputGrade(languageG) && checkInputGrade(literatureG) && checkInputGrade(historyG) && checkInputGrade(nationalityG) && checkInputGrade(bibleG))
        {
            if(notEmpty) {
                Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show();
                // next screen
                Intent si1 = new Intent(this, Mogbar.class);
                si1.putExtra("name", name);
                si1.putExtra("languageG", languageG);
                si1.putExtra("literatureG", literatureG);
                si1.putExtra("historyG", historyG);
                si1.putExtra("nationalityG", nationalityG);
                si1.putExtra("bibleG", bibleG);
                startActivity(si1);
            }

        }
        else
        {
            Toast.makeText(getApplicationContext(),"grade is a number between 0-100. try again",Toast.LENGTH_SHORT).show();
        }
    }
}