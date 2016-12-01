package com.example.jkast.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FindEvents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_events);
    }

    public void birdwatching(View view){
        Intent birdwatchingButton = new Intent(this,Birdwatching.class); // switches to birdwatching
        startActivity(birdwatchingButton);
    }

    public void itSeminar(View view){
        //Intent itSeminarButton = new Intent(this,IT_Seminar.class); // switches to it seminar
        //startActivity(itSeminarButton);
    }
}
