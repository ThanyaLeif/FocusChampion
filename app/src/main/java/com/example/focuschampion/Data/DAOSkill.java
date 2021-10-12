package com.example.focuschampion.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.focuschampion.Models.Skill;

import java.util.ArrayList;

public class DAOSkill {
    private final SQLiteDatabase database;

    public DAOSkill(Context context) {
        database = new DBConnection(context).getWritableDatabase();
    }

    public long insert(Skill skill){
        ContentValues contentValues = new ContentValues();

        contentValues.put("_id", skill.getId());
        contentValues.put("_name", skill.getName());

        return database.insert("skill", null, contentValues);
    }

    public long update(Skill skill){
        ContentValues contentValues = new ContentValues();

        contentValues.put("_name", skill.getName());

        return database.update("skill", contentValues, "_id=?",
                new String[]{String.valueOf(skill.getId())});
    }

    public long delete(int id){
        return database.delete("skill", "_id=?",
                new String[]{String.valueOf(id)});
    }

    public ArrayList<Skill> getAll(){
        ArrayList<Skill> list = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM skill", new String[]{});

        while (cursor.moveToNext()){
            list.add(fromCursor(cursor));
        }

        return list;
    }

    public Skill get(int id){
        Cursor cursor = database.rawQuery("SELECT * FROM skill WHERE _id=? LIMIT 1",
                new String[]{String.valueOf(id)});

        cursor.moveToNext();

        return fromCursor(cursor);
    }

    private Skill fromCursor(Cursor cursor){
        return new Skill(
                cursor.getInt(0),
                cursor.getString(1)
        );
    }
}
