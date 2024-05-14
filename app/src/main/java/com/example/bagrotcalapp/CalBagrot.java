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

    final int BONUS4U = 15;
    final int BONUS5U = 25;

    String name, summary, avgs;
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
        tVAvgs.setText(avgsText());

    }

    public String summaryText()
    {
        name = gi3.getStringExtra("name");
        languageG = gi3.getIntExtra("languageG",222);
        literatureG = gi3.getIntExtra("literatureG",222);
        historyG = gi3.getIntExtra("historyG",222);
        nationalityG = gi3.getIntExtra("nationalityG",222);
        bibleG = gi3.getIntExtra("bibleG",222);

        mathG = gi3.getIntExtra("mathG",222);
        englishG = gi3.getIntExtra("englishG",222);
        mathU = gi3.getIntExtra("mathU", 1);
        englishU = gi3.getIntExtra("englishU", 1);

        mogbar1 = gi3.getIntExtra("mogbar1", 222);
        mogbar2 = gi3.getIntExtra("mogbar2", 222);

        summary = "Here are your grades"  + name + ":\n";
        summary += "language 2 units: " + languageG + "\n";
        summary += "literature 2 units: " + literatureG + "\n";
        summary += "history 2 units: " + historyG + "\n";
        summary += "nationality 2 units: " + nationalityG + "\n";
        summary += "bible 2 units: " + bibleG + "\n";
        summary += "math" + mathU +" units: " + mathG + "\n";
        summary += "english" + englishU +" units: " + englishG + "\n";
        summary += "english" + englishU +" units: " + englishG + "\n";
        summary += "mogbar 5 units: " + mogbar1 + "\n";

        option = gi3.getIntExtra("option",222);
        if(option == 1)
        {
            summary += "mogbar 1 units: " + mogbar2 + "\n";
        }
        else if(option == 2)
        {
            summary += "mogbar 5 units: " + mogbar2 + "\n";
        }
        else
        {
            mogbar3 = gi3.getIntExtra("mogbar3", 222);
            summary += "mogbar 5 units: " + mogbar2 + "\n";
            summary += "mogbar 5 units: " + mogbar3 + "\n";
        }

        return summary;
    }

    public String avgsText()
    {
        int unitsN = 10+mathU+englishU;
        mogbar1 = (mogbar1+BONUS5U) * 5;

        avgs = "Your averages: ";
        if(option == 1) {
            avgs += "\nNormal: " + ((sumAllWOutMogbar()+ mogbar2)/(unitsN+1));
            avgs += "\nWith Mogbar 1: " + ((sumAllWOutMogbar() + mogbar2 + mogbar1) / (unitsN + 6));
        }
        else if(option == 2)
        {
            avgs += "\nNormal: " + (sumAllWOutMogbar()/unitsN);
            mogbar2 = (mogbar2+BONUS5U) * 5;
            avgs += "\nWith Mogbar 1: " + (sumAllWOutMogbar()+ mogbar1/(unitsN+5));
            avgs += "\nWith Mogbar 2: " + (sumAllWOutMogbar()+ mogbar2/(unitsN+5));
            avgs += "\nWith Mogbar 1+2: " + (sumAllWOutMogbar()+ mogbar1 + mogbar2/(unitsN+5+5));
        }
        else if(option == 3)
        {
            avgs += "\nNormal: " + (sumAllWOutMogbar()/unitsN);
            mogbar2 = (mogbar2+BONUS5U) * 5;
            mogbar3 = (mogbar3+BONUS5U) * 5;
            avgs += "With Mogbar 1: " + ((sumAllWOutMogbar()+ mogbar1)/(unitsN+5));
            avgs += "\nWith Mogbar 2: " + ((sumAllWOutMogbar()+ mogbar2)/(unitsN+5));
            avgs += "\nWith Mogbar 3: " + ((sumAllWOutMogbar()+ mogbar3)/(unitsN+5));
            avgs += "\nWith Mogbar 1+2: " + ((sumAllWOutMogbar()+ mogbar1 + mogbar2)/(unitsN+5+5));
            avgs += "\nWith Mogbar 2+3: " + ((sumAllWOutMogbar()+ mogbar2 + mogbar3)/(unitsN+5+5));
            avgs += "\nWith Mogbar 1+3: " + ((sumAllWOutMogbar()+ mogbar1 + mogbar3)/(unitsN+5+5));
            avgs += "\nWith Mogbar 1+2+3: " + ((sumAllWOutMogbar()+ mogbar1 + mogbar2 + mogbar3)/(unitsN+5+5+5));
        }

        return avgs;
    }

    public int sumAllWOutMogbar()
    {
        int sum = mathG*mathU + englishG*englishU;
        sum = languageG*2 + literatureG*2 + historyG*2 + nationalityG*2 + bibleG*2;
        if(mathU == 4)
        {
            sum += (mathG+BONUS4U)*mathU;
        }
        else if(mathU == 5)
        {
            sum += (mathG+BONUS5U)*mathU;
        }

        if(englishU == 4)
        {
            sum += (englishG+BONUS4U)*englishU;
        }
        else if(englishU == 5)
        {
            sum += (englishG+BONUS5U)*englishU;
        }

        return sum;
    }

    public void secScreen(View view) {
        finish();
    }
}