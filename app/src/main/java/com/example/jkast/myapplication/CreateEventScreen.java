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

import static android.widget.Toast.makeText;

public class CreateEventScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    LoginActivity loginActivity = new LoginActivity();
    DatabaseHelper dbh;
    EditText eventName, eventDate, eventTime, eventCreatedBy, eventLocation, eventDetails,
            eventCapacity, eventCategory;
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
        eventName = (EditText)findViewById(R.id.enter_event_name);
        eventDate = (EditText)findViewById(R.id.create_event_date);
        eventTime = (EditText)findViewById(R.id.create_event_time);
        //eventCreatedBy = (EditText)findViewById(R.id.enter_event_name);           // need to fix
        eventLocation = (EditText)findViewById(R.id.create_event_location);
        //eventDetails = (EditText)findViewById(R.id.create_event_details);         // need to fix
        //eventCapacity = (EditText)findViewbyId(R.id.create_event_capacity);       // need to fix
        //eventCategory = (EditText)findViewById(R.id.category_spinner);            // need to fix
        createEventButton = (Button)findViewById(R.id.create_even_new_btn);

        // call action performed-type method
        actionPerformed();
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                System.out.println("YOU SELECTED ANIMALS");
                // Whatever you want to happen when the first item gets selected
                break;
            case 1: System.out.println("YOU SELECTED AGRICULTURE");
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
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
                        loginActivity.getUsername(), // col_5 createdBy
                        eventLocation.getText().toString(), // col_6 location
                        "detailsExample",//eventTime.getText().toString(), // col_7 details
                        30,//eventTime.getText().toString(), // col_8 capacity
                        spinner.getSelectedItem().toString() // col_9 category
                );
                if(isInserted){
                    System.out.println("THE USERNAME IS: " + loginActivity.getUsername());
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