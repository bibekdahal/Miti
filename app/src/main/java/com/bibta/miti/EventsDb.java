package com.bibta.miti;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EventsDb extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MitiEvents.db";
    public static final int DATABASE_VERSION = 1;

    public EventsDb(Context context)
    {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE events (" +
                        "id INTEGER PRIMARY KEY, " +
                        "title TEXT, " +
                        "details TEXT, " +
                        "type INTEGER, " +
                        "year INTEGER, " +
                        "month INTEGER, " +
                        "day INTEGER" +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS events");
        onCreate(db);
    }

    public void insert(String title, String details, int type, int year, int month, int day) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("details", details);
        values.put("type", type);
        values.put("year", year);
        values.put("month", month);
        values.put("day", day);
        db.insert("events", null, values);
        db.close();
    }

    public void update(long id, String title, String details, int type, int year, int month, int day) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("details", details);
        values.put("type", type);
        values.put("year", year);
        values.put("month", month);
        values.put("day", day);
        db.update("events", values, "id=?", new String[]{id + ""});
        db.close();
    }

    public Cursor get(long id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM events WHERE id=?", new String[]{id+""});
        db.close();
        return c;
    }

    // TODO: Don't return cursor (as it's invalid after closing db. Return Event object instead.
    public Cursor get(String key, String value) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM events WHERE "+key+"=?", new String[]{value+""});
        db.close();
        return c;
    }

    public void delete(long id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("events", "id=?", new String[]{id+""});
        db.close();
    }
}
