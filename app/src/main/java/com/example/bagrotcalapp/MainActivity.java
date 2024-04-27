package com.example.bagrotcalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        nextBtn = findViewById(R.id.nextBtn);
    }

    boolean checkInputGrade(int input)
    {
        if(input > 100)
        {
            toast = Toast.makeText(getApplicationContext(),"grade is a number between 1-100. try again",Toast.LENGTH_SHORT);
            return false;
        }
        return true;
    }

    public void nextScreen(View view) {
        // get valid grades from the editexts and the user name.
        nameG = eTname.getText().toString();
        languageG = Integer.valueOf(eTlanguage.getText().toString());
        literatureG = Integer.valueOf(eTliterature.getText().toString());
        historyG = Integer.valueOf(eThistory.getText().toString());
        nationalityG = Integer.valueOf(eTnationality.getText().toString());
        bibleG = Integer.valueOf(eTbible.getText().toString());

        if(checkInputGrade(languageG) && checkInputGrade(literatureG) && checkInputGrade(historyG) && checkInputGrade(nationalityG) && checkInputGrade(bibleG))
        {
            toast = Toast.makeText(getApplicationContext(),"Yes",Toast.LENGTH_SHORT);
            // next screen
            Intent si = new Intent(this,MogbarSubjects.class);
            si.putExtra("nameG",nameG);
            si.putExtra("languageG",languageG);
            si.putExtra("literatureG",literatureG);
            si.putExtra("historyG",historyG);
            si.putExtra("nationalityG",nationalityG);
            si.putExtra("bibleG",bibleG);
            startActivity(si);

        }
    }
}