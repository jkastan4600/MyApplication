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

    public static final String USER_TABLE = "Users";
    public static final String USERLIKES_TABLE = "UserLikes";
    public static final String EVENTS_TABLE = "Events";

    public static final String COL_2 = "FirstName";
    public static final String COL_3 = "LastName";
    public static final String COL_4 = "Username";
    public static final String COL_5 = "Password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +USER_TABLE+ "(UID INTEGER PRIMARY KEY AUTOINCREMENT, FirstName TEXT, LastName TEXT, Username TEXT, Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(db);
    }

    public boolean insertData(String firstName, String lastName, String username, String password){
        boolean result = false;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,firstName);
        contentValues.put(COL_3,lastName);
        contentValues.put(COL_4,username);
        contentValues.put(COL_5,password);

        long val = db.insert(USER_TABLE, null, contentValues);
        if(val == -1){
            result = false;
        }
        else {
            result = true;
        }

        return result;
    }
}
