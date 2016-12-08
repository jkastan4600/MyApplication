package com.example.jkast.myapplication;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class EventDetails extends AppCompatActivity {
    DatabaseHelper DH;
    Button attendButton;
    String username = "hej";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        DH = new DatabaseHelper(this);
        attendButton = (Button) findViewById(R.id.button_to_attend_event); // attend button

        Bundle bundle2 = getIntent().getExtras();
        int UIDofevent = bundle2.getInt("eventUIDfromFind");
        //sets event name
        TextView tvName = (TextView)findViewById(R.id.eventname);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            tvName.setText(bundle.getString("eventnamefromFind"));
        }

        TextView tvDescription = (TextView)findViewById(R.id.eventdescription);
        tvDescription.setText("Description of Event:\n " + DH.getEventDescription(UIDofevent));

        TextView tvDateAndTime = (TextView)findViewById(R.id.eventdateandtime);
        tvDateAndTime.setText("Date of Event: " + DH.getEventDate(UIDofevent) +
                "\nTime of Event: " + DH.getEventTime(UIDofevent));

        TextView tvCreator = (TextView)findViewById(R.id.eventcreator);
        tvCreator.setText("Event Creator: " + DH.getEventCreator(UIDofevent));

        TextView tvLocation = (TextView)findViewById(R.id.eventlocation);
        tvLocation.setText("Location of Event: " + DH.getEventLocation(UIDofevent));
        actionPerformed();
    }

    public void actionPerformed(){
        final Intent eventAttended = new Intent(this,MainMenu.class); // intent to return to menu

        attendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Bundle bundle2 = getIntent().getExtras();
                int UIDofEvent = bundle2.getInt("eventUIDfromFind");
                username = bundle2.getString("emailEventdetails");
                Bundle bundle1 = new Bundle();
                //Add your data to bundle
                bundle1.putString("email", username);
                //Add the bundle to the intent
                eventAttended.putExtras(bundle1);

                boolean isInserted = DH.insertEventAtendee(UIDofEvent, username);

                eventAttended.putExtras(bundle2);
                if(isInserted){
                    makeText(EventDetails.this,"You are attending the selected event.", Toast.LENGTH_LONG).show();
                    startActivity(eventAttended) ;// switches to find events
                }
                else{
                    makeText(EventDetails.this,"Cannot attend event.", Toast.LENGTH_LONG).show();

                }


            }
        });
    }
}
