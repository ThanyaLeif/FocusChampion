package com.example.focuschampion.Data;

import android.content.Context;
import android.content.pm.InstrumentationInfo;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Struct;

public class DBConnection extends SQLiteOpenHelper {

    private String CREATE_DB_SCRIPT = "create table user (" +
            "_nickname text primary key," +
            "_password text)";

    private String CREATE_TABLE_TASK = "create table task (" +
            "_id integer primary key autoincrement," +
            "_name text, _description text, _userId text," +
            "_state text, _difficulty text)";

    private String CREATE_TABLE_SKILL = "create table skill (" +
            "_id integer primary key autoincrement," +
            "_name text)";

    private String CREATE_TABLE_POINTS = "create table points (" +
            "_id integer primary key autoincrement," +
            "_userId text, _accumulatedPoints int)";

    private String CREATE_TABLE_ATTRIBUTE = "create table attribute (" +
            "_id integer primary key autoincrement," +
            "_taskId int, _skillId int)";

    public DBConnection(Context context) {
        super(context, "db_focus_champion", null, 7);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_DB_SCRIPT);
        database.execSQL(CREATE_TABLE_TASK);
        database.execSQL(CREATE_TABLE_SKILL);
        database.execSQL(CREATE_TABLE_POINTS);
        database.execSQL(CREATE_TABLE_ATTRIBUTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS user");
        database.execSQL("DROP TABLE IF EXISTS task");
        database.execSQL("DROP TABLE IF EXISTS skill");
        database.execSQL("DROP TABLE IF EXISTS points");
        database.execSQL("DROP TABLE IF EXISTS attribute");
    }
}
