package com.example.jkast.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainMenu extends AppCompatActivity {
    Button myLikes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //myLikes = (Button) findViewById(R.id.mm_mylikes_edit);
        //actionPerformed();

    }



    public void myEventsButton(View view){
        Intent myEventsButton = new Intent(this,MyEvents.class); // switches to Find Events
        //Get the bundle
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        String stuff = bundle.getString("email"); // problem
        //Create the bundle
        Bundle bundle2 = new Bundle();
        //Add your data to bundle
        bundle2.putString("email", stuff);
        //Add the bundle to the intent
        myEventsButton.putExtras(bundle2);
        // switches to create new event
        startActivity(myEventsButton);
        //finish();
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
        bundle2.putString("email", stuff);
        //Add the bundle to the intent
        findEventsButton.putExtras(bundle2);
        // switches to create new event
        startActivity(findEventsButton);
        //finish();
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
        bundle2.putString("email", stuff);
        //Add the bundle to the intent
        createNewEventIntent.putExtras(bundle2);
        // switches to create new event
        startActivity(createNewEventIntent);
        //finish();
    }

    public void logoutButton(View view){
        Intent logoutIntent = new Intent(this,WelcomeScreen.class);
        startActivity(logoutIntent);
        //finish();
    }

    public void editMyLikes(View view){
        Intent createNewEventIntent = new Intent(this,EditMyLikes.class);
        //Get the bundle
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        String stuff = bundle.getString("email");
        //Create the bundle
        Bundle bundle2 = new Bundle();
        //Add your data to bundle
        bundle2.putString("email", stuff);
        //Add the bundle to the intent
        createNewEventIntent.putExtras(bundle2);
        // switches to create new event
        startActivity(createNewEventIntent);
        //finish();
    }
}
