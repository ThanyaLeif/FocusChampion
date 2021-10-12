package com.example.focuschampion.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.focuschampion.Models.Attribute;

import java.util.ArrayList;

public class DAOAttributes {
    private final SQLiteDatabase database;

    public DAOAttributes(Context context) {
        database = new DBConnection(context).getWritableDatabase();
    }

    public long insert(Attribute attributes){
        ContentValues contentValues = new ContentValues();

        contentValues.put("_id", attributes.getId());
        contentValues.put("_taskId", attributes.getTaskId());
        contentValues.put("_skillId", attributes.getSkillId());

        return database.insert("attribute", null, contentValues);
    }

    public long update(Attribute attribute){
        ContentValues contentValues = new ContentValues();

        contentValues.put("_taskId", attribute.getTaskId());
        contentValues.put("_skillId", attribute.getSkillId());

        return database.update("attribute", contentValues, "_id=?",
                new String[]{String.valueOf(attribute.getId())});
    }

    public long delete(int id){
        return database.delete("attribute", "_id=?",
                new String[]{String.valueOf(id)});
    }

    public ArrayList<Attribute> getAllFromTask(Attribute attribute){
        ArrayList<Attribute> list = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM attribute WHERE _idTask=?",
                new String[]{String.valueOf(attribute.getTaskId())});

        while (cursor.moveToNext()){
            list.add(fromCursor(cursor));
        }

        return list;
    }

    public Attribute get(int id){
        Cursor cursor = database.rawQuery("SELECT * FROM attribute WHERE _id=? LIMIT 1",
                new String[]{String.valueOf(id)});

        cursor.moveToNext();

        return fromCursor(cursor);
    }

    private Attribute fromCursor(Cursor cursor){
        return new Attribute(
                cursor.getInt(0),
                cursor.getInt(1),
                cursor.getInt(2)
        );
    }
}
