package com.example.lohia.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class User_login_data extends SQLiteOpenHelper {

    private static final String USER_DATABASE= "user_database";
    private static final String USER_TABLE= "user_data";
    private static final int VERSION= 1;
    private static final String NAME= "username";
    private static final String PASS= "password";
    private static final String KEY_ID= "id";
    public User_login_data(@Nullable Context context) {
        super(context, USER_DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + USER_TABLE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME +" TEXT ," + PASS +" TEXT" + ")" );




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(db);
    }
    public void add_user(String name, String pass){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(PASS, pass);

        sqLiteDatabase.insert(USER_TABLE,null,values);
    }
}
