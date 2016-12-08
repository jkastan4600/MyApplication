package com.example.jkast.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class Birdwatching extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birdwatching);
    }

    public void attendButton(View view){
        makeText(Birdwatching.this,"You are scheduled to attend this event.", Toast.LENGTH_LONG).show();
        Intent returnToMainMenu = new Intent(this,MainMenu.class); // switches to it main menu
        startActivity(returnToMainMenu);
    }
}
