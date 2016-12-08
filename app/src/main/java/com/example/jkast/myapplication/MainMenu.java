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
        myLikes = (Button) findViewById(R.id.mm_mylikes_edit);
        actionPerformed();
    }



    public void findEventsButton(View view){
        Intent findEventsButton = new Intent(this,FindEvents.class); // switches to Find Events
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
        bundle.putString("email2", stuff);
        //Add the bundle to the intent
        createNewEventIntent.putExtras(bundle);
        // switches to create new event
        startActivity(createNewEventIntent);
    }

    public void actionPerformed() {
        final Intent myLikesIntent = new Intent(this,EditMyLikes.class);
        myLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(myLikesIntent);
            }
        });
    }
}
