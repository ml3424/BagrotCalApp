package com.example.bagrotcalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Mogbar extends AppCompatActivity {
    Button nextBtn2;
    EditText eTmath, eTenglish, eTmathU, eTenglishU, eTMogbar1, eTMogbar2, eTMogbar3;
    RadioButton rB51, rB55, rB555;
    Intent si3;

    final int MAX_G = 100;
    final int MAX_UNITS = 5;
    final int MIN_UNITS = 3;

    String name;
    int languageG, literatureG, historyG, nationalityG, bibleG, mathG, englishG, mathU, englishU, mogbar1, mogbar2, mogbar3, option;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mogbar);

        Intent gi = getIntent();
        name = gi.getStringExtra("name");
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
        eTmathU = findViewById(R.id.eTmathU);
        eTenglish = findViewById(R.id.eTenglish);
        eTenglishU = findViewById(R.id.eTenglishU);

        eTMogbar1 = findViewById(R.id.eTMogbar1);
        eTMogbar2 = findViewById(R.id.eTMogbar2);
        eTMogbar3 = findViewById(R.id.eTMogbar3);
        // hide them
        eTMogbar1.setVisibility(View.GONE);
        eTMogbar2.setVisibility(View.GONE);
        eTMogbar3.setVisibility(View.GONE);

        nextBtn2 = findViewById(R.id.nextBtn2);
    }

    public void chooseOp(View view) {
        if(rB51.isChecked())
        {
            eTMogbar1.setVisibility(View.VISIBLE);
            eTMogbar2.setVisibility(View.VISIBLE);
            eTMogbar3.setVisibility(View.GONE);
            eTMogbar1.setHint("5 units garde:");
            eTMogbar2.setHint("1 unit grade:");
            option = 1;
        }
        else if(rB55.isChecked())
        {
            eTMogbar1.setVisibility(View.VISIBLE);
            eTMogbar2.setVisibility(View.VISIBLE);
            eTMogbar3.setVisibility(View.GONE);
            eTMogbar1.setHint("garde:");
            eTMogbar2.setHint("garde:");
            option = 2;
        }
        else
        {
            eTMogbar1.setVisibility(View.VISIBLE);
            eTMogbar2.setVisibility(View.VISIBLE);
            eTMogbar3.setVisibility(View.VISIBLE);
            eTMogbar1.setHint("garde:");
            eTMogbar2.setHint("garde:");
            option = 3;
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

    public boolean checkEmpty(String input)
    {
        if(input.isEmpty())
        {
            return true;
        }
        return false;
    }

    public void thirdScreen(View view) {
        // get valid grades and units from the editexts.
        boolean notEmpty = true;
        if(checkEmpty(eTmath.getText().toString()) || checkEmpty(eTenglish.getText().toString()) || checkEmpty(eTmathU.getText().toString()) || checkEmpty(eTenglishU.getText().toString()) || checkEmpty(eTMogbar1.getText().toString()) || checkEmpty(eTMogbar2.getText().toString()))
        {
            notEmpty = false;
            Toast.makeText(getApplicationContext(),"One or more is empty. try again",Toast.LENGTH_SHORT).show();
        }
        else
        {
            mathG = Integer.valueOf(eTmath.getText().toString());
            englishG= Integer.valueOf(eTenglish.getText().toString());

            mathU = Integer.valueOf(eTmathU.getText().toString());
            englishU = Integer.valueOf(eTenglishU.getText().toString());

            mogbar1 = Integer.valueOf(eTMogbar1.getText().toString());
            mogbar2 = Integer.valueOf(eTMogbar2.getText().toString());

            if(rB555.isChecked())
            {
                if(checkEmpty(eTMogbar3.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"One or more is empty. try again",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mogbar3 = Integer.valueOf(eTMogbar3.getText().toString());
                }
            }
        }



        if(checkInputGrade(mathG, MAX_G, 0) && checkInputGrade(englishG, MAX_G, 0) && checkInputGrade(mogbar1, MAX_G, 0) && checkInputGrade(mogbar2, MAX_G, 0) && checkInputGrade(mogbar3, MAX_G, 0)) {
            if(checkInputGrade(mathU, MAX_UNITS, MIN_UNITS) && checkInputGrade(englishU, MAX_UNITS, MIN_UNITS)) {
                if(notEmpty) {
                    if(rB51.isChecked() || rB55.isChecked() || rB555.isChecked()) {
                        // send data to the third screen
                        si3.putExtra("name", name);
                        si3.putExtra("languageG", languageG);
                        si3.putExtra("literatureG", literatureG);
                        si3.putExtra("historyG", historyG);
                        si3.putExtra("nationalityG", nationalityG);
                        si3.putExtra("bibleG", bibleG);
                        si3.putExtra("mathG", mathG);
                        si3.putExtra("englishG", englishG);
                        si3.putExtra("mathU", mathU);
                        si3.putExtra("englishU", englishU);
                        si3.putExtra("option", option);


                        if (rB51.isChecked() || rB51.isChecked()) {
                            si3.putExtra("mogbar1", mogbar1);
                            si3.putExtra("mogbar2", mogbar2);
                        } else {
                            si3.putExtra("mogbar1", mogbar1);
                            si3.putExtra("mogbar2", mogbar2);
                            si3.putExtra("mogbar3", mogbar3);
                        }
                        startActivity(si3);
                    }
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