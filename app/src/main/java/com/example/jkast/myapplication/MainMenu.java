package com.example.jkast.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void findEventsButton(View view){
        Intent findEventsButton = new Intent(this,FindEvents.class); // switches to Find Events
        startActivity(findEventsButton);
    }

    public void createNewEventButton(View view){
        Intent createNewEventIntent = new Intent(this,CreateEventScreen.class); // switches to
        startActivity(createNewEventIntent);                                    // create new event
    }
}
