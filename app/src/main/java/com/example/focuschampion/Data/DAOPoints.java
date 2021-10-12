package com.example.focuschampion.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.focuschampion.Models.Points;

import java.util.ArrayList;

public class DAOPoints {
    private final SQLiteDatabase database;

    public DAOPoints(Context context) {
        database = new DBConnection(context).getWritableDatabase();
    }

    public long insert(Points points){
        ContentValues contentValues = new ContentValues();

        contentValues.put("_id", points.getId());
        contentValues.put("_skillId", points.getSkillId());
        contentValues.put("_userId", points.getUserId());
        contentValues.put("_accumulatedPoints", points.getAccumulatedPoints());

        return database.insert("points", null, contentValues);
    }

    public long update(Points points){
        ContentValues contentValues = new ContentValues();

        contentValues.put("_accumulatedPoints", points.getAccumulatedPoints());

        return database.update("points", contentValues, "_userId=? AND _skillId=?",
                new String[]{points.getUserId(), String.valueOf(points.getSkillId())});
    }

    public long delete(int id){
        return database.delete("points", "_id=?",
                new String[]{String.valueOf(id)});
    }

    public ArrayList<Points> getAllFromUser(Points points){
        ArrayList<Points> list = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM points WHERE _userId=?",
                new String[]{points.getUserId()});

        while (cursor.moveToNext()){
            list.add(fromCursor(cursor));
        }

        return list;
    }

    public Points get(int id){
        Cursor cursor = database.rawQuery("SELECT * FROM points WHERE _id=? LIMIT 1",
                new String[]{String.valueOf(id)});

        cursor.moveToNext();

        return fromCursor(cursor);
    }

    private Points fromCursor(Cursor cursor){
        return new Points(
                cursor.getInt(0),
                cursor.getInt(1),
                cursor.getString(2),
                cursor.getInt(3)
        );
    }
}
