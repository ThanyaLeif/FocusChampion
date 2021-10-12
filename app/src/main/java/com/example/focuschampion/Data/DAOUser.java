package com.example.focuschampion.Data;

import android.app.SharedElementCallback;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.focuschampion.Models.User;

import java.util.ArrayList;
import java.util.Currency;

public class DAOUser {
    private SQLiteDatabase database;

    public DAOUser(Context context) {
        database = new DBConnection(context).getWritableDatabase();
    }

    public long insert(User user){
        ContentValues contentValues = new ContentValues();
        contentValues.put("_nickname", user.getNickname());
        contentValues.put("_password", user.getPassword());
        return database.insert("user", null, contentValues);
    }

    public long update(User user){
        ContentValues contentValues = new ContentValues();

        contentValues.put("_password", user.getPassword());

        return database.update("user", contentValues, "_nickname=?",
                new String[] {String.valueOf(user.getNickname())});
    }

    public long delete(User user){
        return database.delete("user", "_nickname=?",
                new String[] {String.valueOf(user.getNickname())});
    }

    public ArrayList<User> getAll(){
        ArrayList <User> list = new ArrayList<>();

        Cursor cursor =  database.rawQuery("SELECT * FROM user", new String[]{});

        while (cursor.moveToNext()){
            list.add(fromCursor(cursor));
        }

        return list;
    }
    
    public User get(User user){
        Cursor cursor = database.rawQuery("SELECT * FROM user WHERE _nickname=? LIMIT 1",
                new String[] {user.getNickname()});

        cursor.moveToNext();

        return fromCursor(cursor);
    }

    private User fromCursor(Cursor cursor){
        return new User(
                cursor.getString(0),
                cursor.getString(1)
        );
    }
}
