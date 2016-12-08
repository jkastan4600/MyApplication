package com.example.jkast.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;
import static android.widget.Toast.makeText;

public class CreateEventScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    LoginActivity loginActivity = new LoginActivity();
    DatabaseHelper dbh;
    EditText eventName;
    EditText eventDate;
    EditText eventTime;
    String eventCreatedBy;
    EditText eventLocation;
    EditText eventDetails;
    EditText eventCapacity;
    Button createEventButton;

    private Spinner spinner;
    private static final String[] paths = {"Animals", "Agriculture", "Archaeology", "Arts & Crafts",
            "Architecture", "Aviation", "Biology", "Bird Watching", "Bombs", "Books", "Collecting",
            "Competition", "Crime", "Culture", "Current Events", "Dance", "Dating", "Doctors",
            "Drama", "Ecology", "Economics", "Education", "Engineering", "Evolution", "Fitness",
            "Flags", "Flowers", "Food", "Fund Raising", "Games", "Gardens/Gardening", "Geography",
            "Government", "Guns", "Health", "History", "Hobbies", "Insects", "Investing",
            "Law Enforcement", "Lunch Outings", "Medicine", "Military", "Magic", "Movies", "Music",
            "Nature", "Parties", "Politics", "Religion", "Sports", "Sight Seeing", "Technology",
            "Theater", "The Colonnades", "Travel", "UVA", "Volunteering", "Weather", "Wine", "Writing"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event_screen);

        spinner = (Spinner) findViewById(R.id.category_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreateEventScreen.this,
                android.R.layout.simple_spinner_item, paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        dbh = new DatabaseHelper(this);


        // cast components
        final Intent createEventIntent1 = new Intent(this,MainMenu.class); // switches to it main menu
        eventName = (EditText)findViewById(R.id.enter_event_name);
        eventDate = (EditText)findViewById(R.id.create_event_date);
        eventTime = (EditText)findViewById(R.id.create_event_time);
        Bundle bundle = getIntent().getExtras();
        eventCreatedBy = bundle.getString("email");
        Bundle bundle2 = new Bundle();
        //Add your data to bundle
        bundle2.putString("email", eventCreatedBy);
        //Add the bundle to the intent
        createEventIntent1.putExtras(bundle2);
        eventLocation = (EditText)findViewById(R.id.create_event_location);
        eventDetails = (EditText)findViewById(R.id.create_event_description);
        eventCapacity = (EditText)findViewById(R.id.create_event_capacity);
        createEventButton = (Button)findViewById(R.id.create_even_new_btn);

        // call action performed-type method
        actionPerformed();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    public void actionPerformed(){
        final Intent createEventIntent = new Intent(this,MainMenu.class); // switches to it main menu

        createEventButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                boolean isInserted = dbh.insertEvent(
                        eventName.getText().toString(), // col_2 name
                        eventDate.getText().toString(), // col_3 date
                        eventTime.getText().toString(), // col_4 time
                        eventCreatedBy, // col_5 createdBy

                        eventLocation.getText().toString(), // col_6 location
                        eventDetails.getText().toString(), // col_7 details
                        Integer.parseInt(eventCapacity.getText().toString()), // col_8 capacity
                        spinner.getSelectedItem().toString() // col_9 category
                );
                Bundle bundle3 = new Bundle();
                //Add your data to bundle
                bundle3.putString("email", eventCreatedBy);
                //Add the bundle to the intent
                createEventIntent.putExtras(bundle3);
                if(isInserted){
                    makeText(CreateEventScreen.this,"Your event has been created.", Toast.LENGTH_LONG).show();
                    startActivity(createEventIntent);
                }
                else{
                    makeText(CreateEventScreen.this,"Event not created.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}