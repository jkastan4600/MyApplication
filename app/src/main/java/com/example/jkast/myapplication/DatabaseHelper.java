package com.example.jkast.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vance Field III on 12/5/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "eventfinder.db";

    public static final String USERS_TABLE = "Users";
    public static final String EVENTS_TABLE = "Events";

    public static final String USERS_COL_2 = "FirstName";
    public static final String USERS_COL_3 = "LastName";
    public static final String USERS_COL_4 = "Username";
    public static final String USERS_COL_5 = "Password";

    public static final String EVENTS_COL_1 = "Name";
    public static final String EVENTS_COL_2 = "Date";
    public static final String EVENTS_COL_3 = "Time";
    public static final String EVENTS_COL_4 = "CreatedBy";
    public static final String EVENTS_COL_5 = "Location";
    public static final String EVENTS_COL_6 = "Details";
    public static final String EVENTS_COL_7 = "Capacity";
    public static final String EVENTS_COL_8 = "Category";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
       // SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("DATABASEHELPER onCreate()");
        db.execSQL("create table " + USERS_TABLE + "(UID INTEGER PRIMARY KEY AUTOINCREMENT, FirstName TEXT, LastName TEXT, Username TEXT, Password TEXT)");
        //db.execSQL("create table " + EVENTS_TABLE + "(Name TEXT PRIMARY KEY, Date DATETIME PRIMARY KEY, Time DATETIME PRIMARY KEY, CreatedBy TEXT, Location TEXT, Details TEXT, Capacity INTEGER, Category TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("DATABASEHELPER onUpgrade()");
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE);
        //db.execSQL("DROP TABLE IF EXISTS " + EVENTS_TABLE);
        onCreate(db);
    }

    /**
     * Creates a row representing a new user in the Users table
     * @param firstName the users first name
     * @param lastName the users last name
     * @param username the users username
     * @param password the users password
     * @return whether or not the insertion was successful
     */
    public boolean insertUser(String firstName, String lastName, String username, String password){
        boolean successfulInsertion = false; // whether the insertion is successful
        SQLiteDatabase db = this.getWritableDatabase(); // must do this each time
        ContentValues contentValues = new ContentValues(); // must do this each time

        // insert the data of the user into each column
        contentValues.put(USERS_COL_2,firstName); // (the column, the data)
        contentValues.put(USERS_COL_3,lastName);
        contentValues.put(USERS_COL_4,username);
        contentValues.put(USERS_COL_5,password);

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
        SQLiteDatabase db = this.getWritableDatabase(); // must do this each time
        ContentValues contentValues = new ContentValues(); // must do this each time

        // insert the data of the event into each column
        contentValues.put(EVENTS_COL_1,name); // (the column, the data)
        contentValues.put(EVENTS_COL_2,date);
        contentValues.put(EVENTS_COL_3,time);
        contentValues.put(EVENTS_COL_4,createdBy);
        contentValues.put(EVENTS_COL_5,location);
        contentValues.put(EVENTS_COL_6,details);
        contentValues.put(EVENTS_COL_7,capacity);
        contentValues.put(EVENTS_COL_8,category);

        long val = db.insert(EVENTS_TABLE, null, contentValues); // (table name, null, the contentValues)
        if(val == -1){ // if unsuccessful
            successfulInsertion = false;
        }
        else { // if successful
            successfulInsertion = true;
        }
        return successfulInsertion;
    }
}
