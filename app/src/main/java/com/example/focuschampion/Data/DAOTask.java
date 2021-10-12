package com.example.focuschampion.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.focuschampion.Models.Task;

import java.util.ArrayList;

public class DAOTask {
    private final SQLiteDatabase database;

    public DAOTask(Context context) {
        database = new DBConnection(context).getWritableDatabase();
    }

    public long insert(Task task){
        ContentValues contentValues = new ContentValues();

        contentValues.put("_id", task.getId());
        contentValues.put("_name", task.getName());
        contentValues.put("_description", task.getDescription());
        contentValues.put("_userId", task.getUserId());
        contentValues.put("_state", task.getStringState());
        contentValues.put("_difficulty", task.getStringDifficulty());

        return database.insert("task", null, contentValues);
    }

    public long update(Task task){
        ContentValues contentValues = new ContentValues();

        contentValues.put("_name", task.getName());
        contentValues.put("_description", task.getDescription());
        contentValues.put("_userId", task.getUserId());
        contentValues.put("_state", task.getStringState());
        contentValues.put("_difficulty", task.getStringDifficulty());

        return database.update("task", contentValues, "_id=?",
                new String[]{String.valueOf(task.getId())});
    }

    public long delete(Task task){
        return database.delete("task", "_id=?",
                new String[]{String.valueOf(task.getId())} );
    }

    public ArrayList<Task> getAll(){
        ArrayList<Task> list = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM task", new String[]{});

        while (cursor.moveToNext()){
            list.add(fromCursor(cursor));
        }

        return list;
    }

    public Task get(int id){
        Cursor cursor = database.rawQuery("SELECT * FROM task WHERE _id=? LIMIT 1",
                new String[]{String.valueOf(id)});

        cursor.moveToNext();

        return fromCursor(cursor);
    }

    private Task fromCursor(Cursor cursor){
        return new Task(
               cursor.getInt(0),
               cursor.getString(1),
               cursor.getString(2),
               cursor.getString(3),
               stringToState(cursor.getString(4)),
                stringToDifficulty(cursor.getString(5))
                );
    }

    private Task.TaskState stringToState(String state){
        if(state == "ACTIVE"){
            return Task.TaskState.ACTIVE;
        }
        else if(state == "CANCELED"){
            return Task.TaskState.CANCELED;
        }
        else {
            return Task.TaskState.FINISHED;
        }
    }

    private Task.DifficultyLevel stringToDifficulty(String state){
        if(state == "EASY"){
            return Task.DifficultyLevel.EASY;
        }
        else if(state == "MEDIUM"){
            return Task.DifficultyLevel.MEDIUM;
        }
        else {
            return Task.DifficultyLevel.HARD;
        }
    }
}
