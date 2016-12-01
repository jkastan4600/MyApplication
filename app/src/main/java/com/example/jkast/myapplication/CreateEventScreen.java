package com.example.jkast.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class CreateEventScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


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

    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
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

    public void createEventButton(View view){
        makeText(CreateEventScreen.this,"You have successfully created your event.", Toast.LENGTH_LONG).show();
        Intent createEventIntent = new Intent(this,MainMenu.class); // switches to it main menu
        startActivity(createEventIntent);
    }
}