package com.example.bagrotcalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MogbarSubjects extends AppCompatActivity {

    Button nextBtn2, prevBtn2;
    EditText eTmath, eTenglish, eTmathU2, eTenglishU2, eTMogbar1, eTMogbar2, eTMogbar3;
    RadioButton rB51, rB55, rB555;
    Intent si3;

    final int MAX_G = 100;
    final int MAX_UNITS = 5;
    final int MIN_UNITS = 3;

    String nameG;
    int languageG, literatureG, historyG, nationalityG, bibleG, mathG, englishG, mathU, englishU, mogbar1, mogbar2, mogbar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mogbar_subjects);

        Intent gi = getIntent();
        nameG = gi.getStringExtra("nameG");
        languageG = gi.getIntExtra("languageG",222);
        literatureG = gi.getIntExtra("literatureG",222);
        historyG = gi.getIntExtra("historyG",222);
        nationalityG = gi.getIntExtra("nationalityG",222);
        bibleG = gi.getIntExtra("bibleG",222);

        si3 = new Intent(this, CalBagrot.class);

        rB51 = findViewById(R.id.rB51);
        rB55 = findViewById(R.id.rB55);
        rB555 = findViewById(R.id.rB555);

        eTmath = findViewById(R.id.eTmath);
        eTmathU2 = findViewById(R.id.eTmathU);
        eTenglish = findViewById(R.id.eTenglish);
        eTenglishU2 = findViewById(R.id.eTenglishU);

        eTMogbar1 = findViewById(R.id.eTMogbar1);
        eTMogbar2 = findViewById(R.id.eTMogbar2);
        eTMogbar3 = findViewById(R.id.eTMogbar3);
        // hide them
        eTMogbar1.setVisibility(View.GONE);
        eTMogbar2.setVisibility(View.GONE);
        eTMogbar3.setVisibility(View.GONE);

        nextBtn2 = findViewById(R.id.nextBtn2);
        prevBtn2 = findViewById(R.id.prevBtn2);


    }

    public void chooseOp(View view) {
        if(rB51.isChecked())
        {
            eTMogbar1.setVisibility(View.VISIBLE);
            eTMogbar2.setVisibility(View.VISIBLE);
            eTMogbar3.setVisibility(View.GONE);
            si3.putExtra("option", 1);
        }
        else if(rB55.isChecked())
        {
            eTMogbar1.setVisibility(View.VISIBLE);
            eTMogbar2.setVisibility(View.VISIBLE);
            eTMogbar3.setVisibility(View.GONE);
            si3.putExtra("option", 2);
        }
        else
        {
            eTMogbar1.setVisibility(View.VISIBLE);
            eTMogbar2.setVisibility(View.VISIBLE);
            eTMogbar3.setVisibility(View.VISIBLE);
            si3.putExtra("option", 3);
        }
    }

    public boolean checkInputGrade(int input, int max, int min)
    {
        if(input >= max && input <= min)
        {
            return false;
        }
        return true;
    }

    public void thirdScreen(View view) {
        // get valid grades and units from the editexts.
        mathG = Integer.valueOf(eTmath.getText().toString());
        englishG= Integer.valueOf(eTenglish.getText().toString());


        mathU = Integer.valueOf(eTmathU2.getText().toString());
        englishU = Integer.valueOf(eTenglishU2.getText().toString());
        //Log.i("Mogbar", String.valueOf(mathU));

        if(rB51.isChecked() || rB55.isChecked())
        {
            mogbar1 = Integer.valueOf(eTMogbar1.getText().toString());
            mogbar2 = Integer.valueOf(eTMogbar2.getText().toString());
            mogbar3 = -1;
        }
        else
        {
            mogbar1 = Integer.valueOf(eTMogbar1.getText().toString());
            mogbar2 = Integer.valueOf(eTMogbar2.getText().toString());
            mogbar3 = Integer.valueOf(eTMogbar3.getText().toString());
        }


        if(checkInputGrade(mathG, MAX_G, 0) && checkInputGrade(englishG, MAX_G, 0) && checkInputGrade(mogbar1, MAX_G, 0) && checkInputGrade(mogbar2, MAX_G, 0) && checkInputGrade(mogbar3, MAX_G, 0)) {
            if(checkInputGrade(mathG, MAX_UNITS, MIN_UNITS) && checkInputGrade(englishG, MAX_UNITS, MIN_UNITS)) {
                if(rB51.isChecked() || rB55.isChecked() || rB555.isChecked()) {
                    // send data to the third screen

                    si3.putExtra("mathG", mathG);
                    si3.putExtra("englishG", englishG);
                    si3.putExtra("mathU", mathU);
                    si3.putExtra("englishU", englishU);


                    si3.putExtra("nameG", nameG);
                    si3.putExtra("languageG", languageG);
                    si3.putExtra("literatureG", literatureG);
                    si3.putExtra("historyG", historyG);
                    si3.putExtra("nationalityG", nationalityG);
                    si3.putExtra("bibleG", bibleG);



                    if(rB51.isChecked() || rB55.isChecked())
                    {
                        si3.putExtra("mogbar1", mogbar1);
                        si3.putExtra("mogbar2", mogbar2);
                    }
                    else
                    {
                        si3.putExtra("mogbar1", mogbar1);
                        si3.putExtra("mogbar2", mogbar2);
                        si3.putExtra("mogbar3", mogbar3);
                    }

                    startActivity(si3);
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Units is a number between 3-5. try again",Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"grade is a number between 0-100. try again",Toast.LENGTH_SHORT).show();
        }
    }

    public void firstScreen(View view) {
        finish();
    }
}