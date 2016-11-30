package com.example.jkast.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

    public void loginButton(View view){
        Intent loginIntent = new Intent(this,LoginActivity.class); // switches to the login screen
        startActivity(loginIntent);
    }

    public void createNewAccountButton(View view){
        Intent createNewAccIntent = new Intent(this,MainActivity.class); // switches to create new..
        startActivity(createNewAccIntent);                               // account screen
    }
}
