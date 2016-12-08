package com.example.jkast.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import static android.view.View.*;
import static android.widget.Toast.makeText;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbh;
    EditText editFirstName, editLastName, editUsername, editPassword;
    Button createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbh = new DatabaseHelper(this);

        // cast components
        editFirstName = (EditText)findViewById(R.id.fname_enter_area);
        editLastName = (EditText)findViewById(R.id.lname_enter_area);
        editUsername = (EditText)findViewById(R.id.email_enter_area);
        editPassword = (EditText)findViewById(R.id.password_enter_area);
        createAccountButton = (Button)findViewById(R.id.button6);

        // call action performed-type method
        actionPerformed();
    }


    public void actionPerformed(){
        final Intent accCreatedIntent = new Intent(this,MyLikes.class);
        createAccountButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                boolean isInserted = dbh.insertUser(
                        editUsername.getText().toString(),
                        editFirstName.getText().toString(),
                        editLastName.getText().toString(),
                        editPassword.getText().toString() );
                if(isInserted){
                    makeText(MainActivity.this,"Account successfully created.", Toast.LENGTH_LONG).show();
                    startActivity(accCreatedIntent) ;// switches to my likes
                }
                else{
                    makeText(MainActivity.this,"Account not created.", Toast.LENGTH_LONG).show();

                }
            }
        });
    }



}
