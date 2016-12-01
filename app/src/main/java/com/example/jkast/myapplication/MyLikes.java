package com.example.jkast.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MyLikes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_likes);
    }

    public void switchToMainMenu(View view){
        Intent likesChosen = new Intent(this, MainMenu.class); // switches to main menu
        startActivity(likesChosen);
    }
}
