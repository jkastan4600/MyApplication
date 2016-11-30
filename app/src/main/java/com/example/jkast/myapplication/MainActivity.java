package com.example.jkast.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static android.widget.Toast.makeText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void accountCreatedDialog(View view){
        makeText(MainActivity.this,"Account successfully created.", Toast.LENGTH_LONG).show();
    }


}
