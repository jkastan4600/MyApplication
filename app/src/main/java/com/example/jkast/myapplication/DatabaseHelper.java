package com.example.jkast.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Vance Field III on 12/5/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public SQLiteDatabase db;
    public static final String DATABASE_NAME = "eventfinder.db";

    public static final String USERS_TABLE = "Users";
    public static final String EVENTS_TABLE = "Events";
    public static final String USERLIKES_TABLE = "UserLikes";
    public static final String EVENTATENDEES_TABLE = "EventAtendees";

    public static final String USERS_COL_1 = "Username";
    public static final String USERS_COL_2 = "FirstName";
    public static final String USERS_COL_3 = "LastName";
    public static final String USERS_COL_4 = "Password";

    public static final String EVENTS_COL_2 = "Name";
    public static final String EVENTS_COL_3 = "Date";
    public static final String EVENTS_COL_4 = "Time";
    public static final String EVENTS_COL_5 = "CreatedBy";
    public static final String EVENTS_COL_6 = "Location";
    public static final String EVENTS_COL_7 = "Details";
    public static final String EVENTS_COL_8 = "Capacity";
    public static final String EVENTS_COL_9 = "Category";

    public static final String USERLIKES_COL_1 = "Username";
    public static final String USERLIKES_COL_2 = "Category";

    public static final String EVENTATENDEE_COL_1 = "EventID";
    public static final String EVENTATENDEE_COL_2 = "Atendee";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        db = this.getWritableDatabase();
    }


    /**
     * Creates a row representing a new user in the Users table
     * @param username the users username
     * @param firstName the users first name
     * @param lastName the users last name
     * @param password the users password
     * @return whether or not the insertion was successful
     */
    public boolean insertUser(String username, String firstName, String lastName, String password){
        boolean successfulInsertion = false; // whether the insertion is successful
        //SQLiteDatabase db = this.getWritableDatabase(); // must do this each time
        ContentValues contentValues = new ContentValues(); // must do this each time

        // insert the data of the user into each column
        contentValues.put(USERS_COL_1,username); // (the column, the data)
        contentValues.put(USERS_COL_2,firstName);
        contentValues.put(USERS_COL_3,lastName);
        contentValues.put(USERS_COL_4,password);

        long val = db.insert(USERS_TABLE, null, contentValues); // (table name, null, the contentValues)
        if(val == -1){ // if unsuccessful
            successfulInsertion = false;
        }
        else { // if successful
            successfulInsertion = true;
        }
        return successfulInsertion;
    }

    /**
     * Creates a row representing a new event in the Events table
     * @param name the name of the event
     * @param date the date of the event
     * @param time the time of the event
     * @param createdBy who created the event
     * @param location the location of the event
     * @param details the details of the event
     * @param capacity the capacity of the event
     * @param category the category of the event
     * @return whether or not the insertion was successful
     */
    public boolean insertEvent(String name, String date, String time, String createdBy,
                               String location, String details, int capacity, String category){

        boolean successfulInsertion = false; // whether the insertion is successful
        //SQLiteDatabase db = this.getWritableDatabase(); // must do this each time
        ContentValues contentValues = new ContentValues(); // must do this each time

        // insert the data of the event into each column
        contentValues.put(EVENTS_COL_2,name); // (the column, the data)
        contentValues.put(EVENTS_COL_3,date);
        contentValues.put(EVENTS_COL_4,time);
        contentValues.put(EVENTS_COL_5,createdBy);
        contentValues.put(EVENTS_COL_6,location);
        contentValues.put(EVENTS_COL_7,details);
        contentValues.put(EVENTS_COL_8,capacity);
        contentValues.put(EVENTS_COL_9,category);


        long val = db.insert(EVENTS_TABLE, null, contentValues); // (table name, null, the contentValues)
        if(val == -1){ // if unsuccessful
            successfulInsertion = false;
        }
        else { // if successful
            successfulInsertion = true;
        }
        return successfulInsertion;
    }


    public String getNameForEvent(int EventID){
        String select = "select * from Events where EventID = '" + EventID + "'";
        String name = "jolly";
        Cursor c = db.rawQuery(select, null);
        if(c.moveToFirst()) {
            do{
                name = c.getString(c.getColumnIndex("Name"));
            } while(c.moveToNext());
        }
        c.close();
        return name;
    }

    //gets event description
    public String getEventDescription(int EventID){
        String select = "select * from Events where EventID = '" + EventID + "'";
        String name = "invalid";
        Cursor c = db.rawQuery(select, null);
        if(c.moveToFirst()) {
            do{
                name = c.getString(c.getColumnIndex("Details"));
            } while(c.moveToNext());
        }
        c.close();
        return name;
    }

    //gets event date
    public String getEventDate(int EventID){
        String select = "select * from Events where EventID = '" + EventID + "'";
        String name = "invalid";
        Cursor c = db.rawQuery(select, null);
        if(c.moveToFirst()) {
            do{
                name = c.getString(c.getColumnIndex("Date"));
            } while(c.moveToNext());
        }
        c.close();
        return name;
    }

    //gets event time
    public String getEventTime(int EventID){
        String select = "select * from Events where EventID = '" + EventID + "'";
        String name = "invalid";
        Cursor c = db.rawQuery(select, null);
        if(c.moveToFirst()) {
            do{
                name = c.getString(c.getColumnIndex("Time"));
            } while(c.moveToNext());
        }
        c.close();
        return name;
    }

    //gets event location
    public String getEventLocation(int EventID){
        String select = "select * from Events where EventID = '" + EventID + "'";
        String name = "invalid";
        Cursor c = db.rawQuery(select, null);
        if(c.moveToFirst()) {
            do{
                name = c.getString(c.getColumnIndex("Location"));
            } while(c.moveToNext());
        }
        c.close();
        return name;
    }

    //gets event capacity
    public String getEventCapacity(int EventID){
        String select = "select * from Events where EventID = '" + EventID + "'";
        String name = "invalid";
        Cursor c = db.rawQuery(select, null);
        if(c.moveToFirst()) {
            do{
                name = c.getString(c.getColumnIndex("Capacity"));
            } while(c.moveToNext());
        }
        c.close();
        return name;
    }

    //gets event creator
    public String getEventCreator(int EventID){
        String select = "select * from Events where EventID = '" + EventID + "'";
        String name = "invalid";
        Cursor c = db.rawQuery(select, null);
        if(c.moveToFirst()) {
            do{
                name = c.getString(c.getColumnIndex("CreatedBy"));
            } while(c.moveToNext());
        }
        c.close();
        return name;
    }

    //gets first item in EVENTS table
    public int getMinEventID(){
        String select = "SELECT * FROM Events LIMIT 1";
        int MIN = 0;
        Cursor c = db.rawQuery(select, null);
        if(c.moveToFirst()) {
            do{
                MIN = c.getInt(c.getColumnIndex("EventID"));
            } while(c.moveToNext());
        }
        c.close();
        return MIN;
    }

    //gets last item in EVENTS table
    public int getMaxEventID() {
        String select = "SELECT * FROM Events ORDER BY EventID DESC LIMIT 1";
        int MAX = 0;
        Cursor c = db.rawQuery(select, null);
        if(c.moveToFirst()) {
            do{
                MAX = c.getInt(c.getColumnIndex("EventID"));
            } while(c.moveToNext());
        }

        //MAX = 116;
        return MAX;
    }

    /**
     * Retrieves the password for the user
     * @param username the users username
     * @return the users password
     */
    public String getPasswordForUser(String username){
        String select = "select * from Users where Username = '" + username + "'";
        String password = "null";
        Cursor c = db.rawQuery(select, null);
        if(c.moveToFirst()) {
            do{
                password = c.getString(c.getColumnIndex("Password"));
            } while(c.moveToNext());
        }
        c.close();
        return password;
    }

    /**
     * Creates a row that represents a user and his/her like
     * @param username the users username
     * @param category the users like
     * @return whether or not the insertion was successful
     */
    public boolean insertUserLikes(String username, String category){
        boolean successfulInsertion = false; // whether the insertion is successful
        ContentValues contentValues = new ContentValues(); // must do this each time

        // insert the data of the user into each column
        contentValues.put(USERLIKES_COL_1,username); // (the column, the data)
        contentValues.put(USERLIKES_COL_2,category);

        long val = db.insert(USERLIKES_TABLE, null, contentValues); // (table name, null, the contentValues)
        if(val == -1){ // if unsuccessful
            successfulInsertion = false;
        }
        else { // if successful
            successfulInsertion = true;
        }
        return successfulInsertion;
    }

    /**
     * Creates a row that represents a user attending an event
     * @param eventID the event ID
     * @param atendee the event atendee
     * @return whether or not the insertion was successful
     */
    public boolean insertEventAtendee(int eventID, String atendee){
        boolean successfulInsertion = false; // whether the insertion is successful
        ContentValues contentValues = new ContentValues(); // must do this each time

        // insert the data of the user into each column
        contentValues.put(EVENTATENDEE_COL_1,eventID); // (the column, the data)
        contentValues.put(EVENTATENDEE_COL_2,atendee);

        long val = db.insert(EVENTATENDEES_TABLE, null, contentValues); // (table name, null, the contentValues)
        if(val == -1){ // if unsuccessful
            successfulInsertion = false;
        }
        else { // if successful
            successfulInsertion = true;
        }
        return successfulInsertion;
    }
    public String getEventAttendee(int EventID){
        String select = "select * from EventAtendees where EventID = '" + EventID + "'";
        String name = "invalid";
        Cursor c = db.rawQuery(select, null);
        if(c.moveToFirst()) {
            do{
                name = c.getString(c.getColumnIndex("Atendee"));
            } while(c.moveToNext());
        }
        c.close();
        return name;

    public ArrayList getAllUserLikes(String username){
        ArrayList list = new ArrayList();
        String like = "";
        String select = "select * from UserLikes where Username = '" + username + "'";
        Cursor c = db.rawQuery(select, null);

        if(c.moveToFirst()) {
            do{
                like = c.getString(c.getColumnIndex("Category"));
                list.add(like);
            } while(c.moveToNext());
        }

        c.close();
        return list;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
