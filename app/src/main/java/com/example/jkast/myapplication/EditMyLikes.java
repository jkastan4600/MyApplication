package com.example.jkast.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.makeText;

public class EditMyLikes extends AppCompatActivity {

    MyLikes myLikesObj;
    public String username;
    DatabaseHelper dbh;
    Bundle bundle;
    List<CheckBox> checkboxList;
    CheckBox Animals, Agriculture, Archaeology, ArtsCrafts,
            Architecture, Aviation, Biology, BirdWatching, Bombs, Books, Collecting,
            Competition, Crime, Culture, CurrentEvents, Dance, Dating, Doctors,
            Drama, Ecology, Economics, Education, Engineering, Evolution, Fitness,
            Flags, Flowers, Food, FundRaising, Games, GardensGardening, Geography,
            Government, Guns, Health, History, Hobbies, Insects, Investing,
            LawEnforcement, LunchOutings, Magic, Medicine, Military, Movies, Music,
            Nature, Parties, Politics, Religion, Sports, SightSeeing, Technology,
            Theater, TheColonnades, Travel, UVA, Volunteering, Weather, Wine, Writing;
    Button backToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_likes);
        dbh = new DatabaseHelper(this);
        myLikesObj = new MyLikes();
        username = "";
        ArrayList list;
        bundle = getIntent().getExtras();
        backToLogin = (Button) findViewById(R.id.set_likes_btn);
        checkboxList = myLikesObj.getCheckboxList(); // represents a list of all checkboxes

        // get all user likes
        list = dbh.getAllUserLikes(username);
        for(int i = 0; i < list.size(); i++){
            System.out.println("alluserLikes["+i+"]" + list.get(i));
        }

        //Animals = (CheckBox)findViewById(R.id.animals);
        //Animals.setChecked(true);
        actionPerformed();
    }

    public void actionPerformed() {
        final Intent likesUpdated = new Intent(this, MainMenu.class);
        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // if(checkboxList.get(0).isChecked())

                // insert user's likes into UserLikes table
                //username = bundle.getString("email"); // this throws an error
               // boolean isInserted = false;
               // for(int i = 0; i < selectedList.size(); i++) {
               //     isInserted = dbh.insertUserLikes(
                //            username, // col_1 username
               //            selectedList.get(i).getText().toString() // col_2 category
               //     );
               // }

                //if (isInserted) {
                //    makeText(EditMyLikes.this, "Account created. Now try logging in.", Toast.LENGTH_LONG).show();
                    startActivity(likesUpdated); // switches to login screen
                //} else {
                //    makeText(EditMyLikes.this, "Event not created.", Toast.LENGTH_LONG).show();
                //}


            }
        });
    }

}
