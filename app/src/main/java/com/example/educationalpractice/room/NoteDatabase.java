package com.example.educationalpractice.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.educationalpractice.classes.Note;

import kotlin.jvm.internal.DefaultConstructorMarker;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase{
    public abstract NoteDAO noteDAO();

    private static NoteDatabase INSTANCE;

    public static NoteDatabase getINSTANCE(Context context) {
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, NoteDatabase.class, "note_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
