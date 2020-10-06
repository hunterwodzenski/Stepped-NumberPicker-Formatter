//package com.site.YOURPACKAGE;


import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

public class NumberPicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        //INCREMENTED NUMBER PICKER
        final NumberPicker siNp = findViewById(R.id.siNp);
        siNp.setMinValue(1);
        //(24*60)/15
        siNp.setMaxValue(96);
        //increment siNp number picker by 15 minutes
        NumberPicker.Formatter siNpFormatter = new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                int min = (i%4)*15;
                int hr = i/4;

                //Return formatted time
                return String.format(Locale.getDefault(),"%d:%02d", hr, min);
            }
        };
        siNp.setFormatter(siNpFormatter);
        siNp.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);


        //STEPPED NUMBER PICKER
        final NumberPicker abtNp = findViewById(R.id.abtNp);
        //1 minute
        abtNp.setMinValue(1);
        //8 hours or 480 minutes
        abtNp.setMaxValue(96);
        //increment abtNP number picker by 1, 5 and 15 minutes
        NumberPicker.Formatter abtNpFormatter = new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                int min = i % 60;
                int hr = i / 60;
                //after 60 minutes
                if(i>60) {
                    //5*12=60
                    min = (i%12)*5;
                    hr = (i/12) - 4;
                }
                //after 120 minutes with step index
                if(i>72) {
                    //4*15=60
                    min = (i%4)*15;
                    hr = (i/4) - 16;
                }
                return String.format(Locale.getDefault(), "%d:%02d", hr, min);
            }
        };
        abtNp.setFormatter(abtNpFormatter);
        abtNp.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);


    }

}