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

    public void myEventsButton(View view){
        Intent myEventsButton = new Intent(this,MyEvents.class); // switches to Find Events
        //Get the bundle
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        String stuff = bundle.getString("email");
        //Create the bundle
        Bundle bundle2 = new Bundle();
        //Add your data to bundle
        bundle2.putString("email2", stuff);
        //Add the bundle to the intent
        myEventsButton.putExtras(bundle2);
        // switches to create new event
        startActivity(myEventsButton);
    }

    public void findEventsButton(View view){
        Intent findEventsButton = new Intent(this,FindEvents.class); // switches to Find Events
        //Get the bundle
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        String stuff = bundle.getString("email");
        //Create the bundle
        Bundle bundle2 = new Bundle();
        //Add your data to bundle
        bundle2.putString("email2", stuff);
        //Add the bundle to the intent
        findEventsButton.putExtras(bundle2);
        // switches to create new event
        startActivity(findEventsButton);
    }

    public void createNewEventButton(View view){
        Intent createNewEventIntent = new Intent(this,CreateEventScreen.class);
        //Get the bundle
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        String stuff = bundle.getString("email");
        //Create the bundle
        Bundle bundle2 = new Bundle();
        //Add your data to bundle
        bundle2.putString("email2", stuff);
        //Add the bundle to the intent
        createNewEventIntent.putExtras(bundle2);
        // switches to create new event
        startActivity(createNewEventIntent);
    }

    public void logoutButton(View view){
        Intent logoutIntent = new Intent(this,LoginActivity.class);
        startActivity(logoutIntent);

    }
}
