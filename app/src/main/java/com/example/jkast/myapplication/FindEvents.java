package com.example.jkast.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FindEvents extends AppCompatActivity {

    DatabaseHelper DH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_events);
        DH = new DatabaseHelper(this);
        int incTable = 100;
        boolean isNextEvent = false;
        int MIN = 100;
        int MAX = 110;
        MIN = DH.getMinEventID(); //gets first item location in table
        MAX = DH.getMaxEventID(); //gets last item location in table

        incTable = MIN;
        //Creates buttons for each event currently created
        while(incTable <= MAX) {

            Button myButton = new Button(this);
            myButton.setText(DH.getNameForEvent(incTable));

            LinearLayout ll = (LinearLayout)findViewById(R.id.dynnam_event_view);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ll.addView(myButton, lp);
            incTable += 1;
    }//ends while loop

    }//ends on create

    public void birdwatching(View view){
        Intent birdwatchingButton = new Intent(this,Birdwatching.class); // switches to birdwatching
        startActivity(birdwatchingButton);
    }

    public void itSeminar(View view){
        //Intent itSeminarButton = new Intent(this,IT_Seminar.class); // switches to it seminar
        //startActivity(itSeminarButton);
    }
}
