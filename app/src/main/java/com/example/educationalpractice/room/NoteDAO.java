package com.example.educationalpractice.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.educationalpractice.classes.Note;

import org.w3c.dom.Entity;

import java.util.List;

@Dao
public interface NoteDAO {
    @Query("SELECT * FROM notes")
    List<Note> getAll();

    @Query("SELECT note_name FROM notes " +
            "WHERE note_id LIKE :id")
    String findNoteNameById(int id);

    @Insert(entity = Note.class, onConflict = OnConflictStrategy.REPLACE)
    void insertNewNote(Note note);

}
