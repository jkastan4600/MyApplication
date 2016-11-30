package com.example.jkast.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showDialog(View view){
        Toast.makeText(MainActivity.this,"Account successfully created.", Toast.LENGTH_LONG).show();
    } // suh suh suh
}
