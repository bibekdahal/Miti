package com.bibta.miti;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;

/**
 * Nepali Tithi Database.
 */
public class TithiDb extends SQLiteOpenHelper{

    /// Database name.
    public static final String DATABASE_NAME = "Tithi.db";
    /// Database version.
    public static final int DATABASE_VERSION = 2;

    /**
     * Create Tithi Database Helper.
     * @param context The context working on the database.
     */
    public TithiDb(Context context)
    {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    /**
     * Create tithi table for given database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tithi (" +
                        "date TEXT PRIMARY KEY, " +
                        "tithi TEXT, " +
                        "extra TEXT" +
                        ")"
        );
    }

    /**
     * Upgrade the database to new version. Basically delete the tithi table and create new one.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        deleteAll(db);
    }

    /**
     * Delete all data in the database.
     */
    public void deleteAll() {
        SQLiteDatabase db = getWritableDatabase();
        deleteAll(db);
        db.close();
    }
    private void deleteAll(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS tithi");
        onCreate(db);
    }

    /**
     * Insert new tithi data.
     * @param date Date for which tithi is being inserted.
     * @param tithi Tithi for the date.
     * @param extra Extra information on the date.
     */
    public void insert(String date, String tithi, String extra) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", date);
        values.put("tithi", tithi);
        values.put("extra", extra);
        db.insert("tithi", null, values);
        db.close();
    }

    /**
     * Update tithi data for a date.
     * @param date Date for which tithi is to be updated.
     * @param tithi New tithi for the date.
     * @param extra Extra information on the date.
     */
    public void update(String date, String tithi, String extra) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tithi", tithi);
        values.put("extra", extra);
        db.update("tithi", values, "date=?", new String[]{date});
        db.close();
    }

    /**
     * Get tithi data for a date.
     * @param date Date for which tithi is to be obtained.
     * @return A pair of strings (tithi, extra) for given date.
     */
    public Pair<String, String> get(String date) {
        SQLiteDatabase db = getReadableDatabase();
        Pair<String, String> c = getTithi(db.rawQuery("SELECT * FROM tithi WHERE date=?",
                new String[]{date}));
        db.close();
        return c;
    }

    /**
     * Delete tithi for a date.
     * @param date Date for which tithi data is to be deleted.
     */
    public void delete(String date) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("tithi", "date", new String[]{date});
        db.close();
    }

    private static Pair<String, String> getTithi(Cursor cursor) {
        if (cursor.getCount() == 0)
            return null;
        cursor.moveToFirst();
        return new Pair<>(
                cursor.getString(cursor.getColumnIndex("tithi")),
                cursor.getString(cursor.getColumnIndex("extra"))
        );
    }
}
