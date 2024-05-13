package com.example.bagrotcalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalBagrot extends AppCompatActivity {

    Button prevBtn3;
    TextView tVSummary, tVAvgs;
    Intent gi3;

    String name, summary;
    int languageG, literatureG, historyG, nationalityG, bibleG, mathG, englishG, mathU, englishU, mogbar1, mogbar2, mogbar3, option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_bagrot);

        tVSummary = findViewById(R.id.tVSummary);
        tVAvgs = findViewById(R.id.tVAvgs);
        prevBtn3 = findViewById(R.id.prevBtn3);

        gi3 = getIntent();
        tVSummary.setText(summaryText());

    }

    public String summaryText()
    {
        mathU = gi3.getIntExtra("mathU", 1);
        englishU = gi3.getIntExtra("englishU", 1);

        name = gi3.getStringExtra("nameG");
        languageG = gi3.getIntExtra("languageG",222);
        literatureG = gi3.getIntExtra("literatureG",222);
        historyG = gi3.getIntExtra("historyG",222);
        nationalityG = gi3.getIntExtra("nationalityG",222);
        bibleG = gi3.getIntExtra("bibleG",222);
        mathG = gi3.getIntExtra("mathG",222);
        englishG = gi3.getIntExtra("englishG",222);



        option = gi3.getIntExtra("option",222);
        if(option == 1 || option == 2)
        {

        }

        summary = "Here are your grades"  + name + ":\n";
        summary += "language 2 units: " + languageG + "\n";
        summary += "literature 2 units: " + literatureG + "\n";
        summary += "history 2 units: " + historyG + "\n";
        summary += "nationality 2 units: " + nationalityG + "\n";
        summary += "bible 2 units: " + bibleG + "\n";
        summary += "math" + mathU +" units: " + mathG + "\n";
        summary += "english" + englishU +" units: " + englishG + "\n";
        return summary;
    }

    public void secScreen(View view) {
        finish();
    }
}