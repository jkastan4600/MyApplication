package com.example.jkast.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.makeText;

public class MyLikes extends AppCompatActivity {

    public String username;
    DatabaseHelper dbh;
    Bundle bundle;
    List<CheckBox> checkboxList;
    List<CheckBox> selectedList;
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
        username = "";
        bundle = getIntent().getExtras();
        backToLogin = (Button) findViewById(R.id.set_likes_btn);
        checkboxList = new ArrayList<CheckBox>(); // represents a list of all checkboxes
        selectedList = new ArrayList<CheckBox>(); // represents a list of all checked checkboxes
        actionPerformed();
    }

    public void actionPerformed() {
        final Intent accCreatedIntent = new Intent(this, LoginActivity.class);
        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // must instantiate after the user selects his/her likes
                Animals = (CheckBox) findViewById(R.id.animals);
                Agriculture = (CheckBox) findViewById(R.id.agriculture);
                Archaeology = (CheckBox) findViewById(R.id.archaeology);
                ArtsCrafts = (CheckBox) findViewById(R.id.artsandcrafts);
                Architecture = (CheckBox) findViewById(R.id.architecture);
                Aviation = (CheckBox) findViewById(R.id.aviation);
                Biology = (CheckBox) findViewById(R.id.Biology);
                BirdWatching = (CheckBox) findViewById(R.id.BirdWatching);
                Bombs = (CheckBox) findViewById(R.id.Bombs);
                Books = (CheckBox) findViewById(R.id.Books);
                Collecting = (CheckBox) findViewById(R.id.Collecting);
                Competition = (CheckBox) findViewById(R.id.Competition);
                Crime = (CheckBox) findViewById(R.id.Crime);
                Culture = (CheckBox) findViewById(R.id.Culture);
                CurrentEvents = (CheckBox) findViewById(R.id.CurrentEvents);
                Dance = (CheckBox) findViewById(R.id.Dance);
                Dating = (CheckBox) findViewById(R.id.Dating);
                Doctors = (CheckBox) findViewById(R.id.Doctors);
                Drama = (CheckBox) findViewById(R.id.Drama);
                Ecology = (CheckBox) findViewById(R.id.Ecology);
                Economics = (CheckBox) findViewById(R.id.Economics);
                Education = (CheckBox) findViewById(R.id.Education);
                Engineering = (CheckBox) findViewById(R.id.Engineering);
                Evolution = (CheckBox) findViewById(R.id.Evolution);
                Fitness = (CheckBox) findViewById(R.id.Fitness);
                Flags = (CheckBox) findViewById(R.id.Flags);
                Flowers = (CheckBox) findViewById(R.id.Flowers);
                Food = (CheckBox) findViewById(R.id.Food);
                FundRaising = (CheckBox) findViewById(R.id.FundRaising);
                Games = (CheckBox) findViewById(R.id.Games);
                GardensGardening = (CheckBox) findViewById(R.id.GardensGardening);
                Geography = (CheckBox) findViewById(R.id.Geography);
                Government = (CheckBox) findViewById(R.id.Government);
                Guns = (CheckBox) findViewById(R.id.Guns);
                Health = (CheckBox) findViewById(R.id.Health);
                History = (CheckBox) findViewById(R.id.History);
                Hobbies = (CheckBox) findViewById(R.id.Hobbies);
                Insects = (CheckBox) findViewById(R.id.Insects);
                Investing = (CheckBox) findViewById(R.id.Investing);
                LawEnforcement = (CheckBox) findViewById(R.id.LawEnforcement);
                LunchOutings = (CheckBox) findViewById(R.id.LunchOutings);
                Magic = (CheckBox) findViewById(R.id.Magic);
                Medicine = (CheckBox) findViewById(R.id.Medicine);
                Military = (CheckBox) findViewById(R.id.Military);
                Movies = (CheckBox) findViewById(R.id.Movies);
                Music = (CheckBox) findViewById(R.id.Music);
                Nature = (CheckBox) findViewById(R.id.Nature);
                Parties = (CheckBox) findViewById(R.id.Parties);
                Politics = (CheckBox) findViewById(R.id.Politics);
                Religion = (CheckBox) findViewById(R.id.Religion);
                Sports = (CheckBox) findViewById(R.id.Sports);
                SightSeeing = (CheckBox) findViewById(R.id.SightSeeing);
                Technology = (CheckBox) findViewById(R.id.Technology);
                Theater = (CheckBox) findViewById(R.id.Theater);
                TheColonnades = (CheckBox) findViewById(R.id.TheColonnades);
                Travel = (CheckBox) findViewById(R.id.Travel);
                UVA = (CheckBox) findViewById(R.id.UVA);
                Volunteering = (CheckBox) findViewById(R.id.Volunteering);
                Weather = (CheckBox) findViewById(R.id.Weather);
                Wine = (CheckBox) findViewById(R.id.Wine);
                Writing = (CheckBox) findViewById(R.id.Writing);

                // adding all checkboxes to the checkboxList
                checkboxList.add(Animals);
                checkboxList.add(Agriculture);
                checkboxList.add(Archaeology);
                checkboxList.add(ArtsCrafts);
                checkboxList.add(Architecture);
                checkboxList.add(Aviation);
                checkboxList.add(Biology);
                checkboxList.add(BirdWatching);
                checkboxList.add(Bombs);
                checkboxList.add(Books);
                checkboxList.add(Collecting);
                checkboxList.add(Competition);
                checkboxList.add(Crime);
                checkboxList.add(Culture);
                checkboxList.add(CurrentEvents);
                checkboxList.add(Dance);
                checkboxList.add(Dating);
                checkboxList.add(Doctors);
                checkboxList.add(Drama);
                checkboxList.add(Ecology);
                checkboxList.add(Economics);
                checkboxList.add(Education);
                checkboxList.add(Engineering);
                checkboxList.add(Evolution);
                checkboxList.add(Fitness);
                checkboxList.add(Flags);
                checkboxList.add(Flowers);
                checkboxList.add(Food);
                checkboxList.add(FundRaising);
                checkboxList.add(Games);
                checkboxList.add(GardensGardening);
                checkboxList.add(Geography);
                checkboxList.add(Government);
                checkboxList.add(Guns);
                checkboxList.add(Health);
                checkboxList.add(History);
                checkboxList.add(Hobbies);
                checkboxList.add(Insects);
                checkboxList.add(Investing);
                checkboxList.add(LawEnforcement);
                checkboxList.add(LunchOutings);
                checkboxList.add(Medicine);
                checkboxList.add(Military);
                checkboxList.add(Magic);
                checkboxList.add(Movies);
                checkboxList.add(Music);
                checkboxList.add(Nature);
                checkboxList.add(Parties);
                checkboxList.add(Politics);
                checkboxList.add(Religion);
                checkboxList.add(Sports);
                checkboxList.add(SightSeeing);
                checkboxList.add(Technology);
                checkboxList.add(Travel);
                checkboxList.add(Theater);
                checkboxList.add(UVA);
                checkboxList.add(Volunteering);
                checkboxList.add(Weather);
                checkboxList.add(Wine);
                checkboxList.add(Writing);

                // adds all checkboxes to the checkboxList
                for (int i = 0; i < checkboxList.size(); i++) {
                    if (checkboxList.get(i).isChecked()) {
                        System.out.println("checkboxList(" + i + "): " + checkboxList.get(i).getText());
                        selectedList.add(checkboxList.get(i));
                    }
                }

                // adds all checked checkboxes from checkboxList to selectedList
                for (int i = 0; i < selectedList.size(); i++) {
                    System.out.println("selectedList(" + i + "): " + selectedList.get(i).getText());


                    // runs for every category
                    //dbh.insertUserLikes(username, selectedList.get(i).getText().toString());
                }

                // insert user's likes into UserLikes table
                username = bundle.getString("email");
                boolean isInserted = false;
                // insert
                for(int i = 0; i < selectedList.size(); i++) {
                     isInserted = dbh.insertUserLikes(
                            username, // col_1 username
                            selectedList.get(i).getText().toString() // col_2 category
                    );
                }

                if (isInserted) {
                    makeText(MyLikes.this, "Account created. Now try logging in.", Toast.LENGTH_LONG).show();
                    startActivity(accCreatedIntent); // switches to login screen
                } else {
                    makeText(MyLikes.this, "Event not created.", Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    /**
     * Returns the checkboxList
     * @return the checkboxList
     */
    public List<CheckBox> getCheckboxList(){
        return checkboxList;
    }

}
