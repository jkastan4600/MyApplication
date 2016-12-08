package com.example.jkast.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyEvents extends AppCompatActivity {

    DatabaseHelper DH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);
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
            Bundle bundle1 = getIntent().getExtras();
            //Extract the data…
            String EMAILofUSER = bundle1.getString("email");
            String createdBYUSER = DH.getEventCreator(incTable);
            String attendeeUSER = DH.getEventAttendee(incTable);
            if (EMAILofUSER.equals(createdBYUSER) || EMAILofUSER.equals(attendeeUSER)) {
            Button myButton = new Button(this);
            myButton.setText(DH.getNameForEvent(incTable));

            final int finalIncTable = incTable;
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent createEventDetailsIntent = new Intent(MyEvents.this, EventDetails.class);
                    ///////////////////
                    Bundle bundle0 = new Bundle();
                    //sets name for event
                    String stuff = DH.getNameForEvent(finalIncTable);
                    //Add the bundle to the intent
                    bundle0.putString("eventnamefromFind", stuff);
                    createEventDetailsIntent.putExtras(bundle0);
                    ///////////////////

                    ///////////////////
                    Bundle bundle1 = getIntent().getExtras();
                    //Extract the data…
                    String stuff2 = bundle1.getString("email");
                    //Create the bundle
                    Bundle bundle2 = new Bundle();
                    //Add your data to bundle
                    bundle2.putString("emailEventdetails", stuff2);
                    bundle2.putInt("eventUIDfromFind", finalIncTable);
                    //Add the bundle to the intent
                    createEventDetailsIntent.putExtras(bundle2);
                    ////////////////////

                    // switches to create new event
                    startActivity(createEventDetailsIntent);
                }
            });

            LinearLayout ll = (LinearLayout) findViewById(R.id.myEVENTSlayout);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ll.addView(myButton, lp);

            incTable += 1; //inc to next event//
            }//ends if
            else {incTable +=1;}
        }//ends while loop

    }//ends on create


    public void itSeminar(View view){
        //Intent itSeminarButton = new Intent(this,IT_Seminar.class); // switches to it seminar
        //startActivity(itSeminarButton);
    }

    public void switchToEventDetails(){
        Intent accLoggedInIntent = new Intent(MyEvents.this, EventDetails.class); // switches to main menu
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.username);
        String getrec = textView.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("eventname", getrec);
        accLoggedInIntent.putExtras(bundle);


        startActivity(accLoggedInIntent);
    }
}
