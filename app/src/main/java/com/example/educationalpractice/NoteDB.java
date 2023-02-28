package com.example.educationalpractice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import org.w3c.dom.DocumentType;

public class NoteDB extends SQLiteOpenHelper {
    /**
     * database name, version
     */
    private static final String DATABASE_NAME = "note-store.db";
    private static final int SCHEMA = 1;
    /**
     * table,
     * column names
     */
    private static final String NOTE_TABLE = "notes";
    private static final String NOTE_ID = "_id";
    private static final String NOTE_NAME = "name";
    private static final String NOTE_DATE = "date";
    private static final String NOTE_DESCRIPTION = "description";
    /**
     * creation string
     */
    private static final String DB_CREATION_STRING = String.format("CREATE TABLE %s (" +
            "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
            "%s TEXT," +
            "%s TEXT," +
            "%s TEXT," +
            "%s TEXT" +
            ");"
            , NOTE_TABLE, NOTE_ID, NOTE_NAME, NOTE_DATE, NOTE_DESCRIPTION);
    public NoteDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DB_CREATION_STRING);
    }
}
