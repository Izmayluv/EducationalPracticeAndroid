package com.example.educationalpractice.classes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity( tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    private long noteId;
    @ColumnInfo(name = "note_name")
    private String noteName;
    @ColumnInfo(name = "note_date")
    private String noteDate;
    @ColumnInfo(name = "note_text")
    private String noteText;

/*    public Note(long noteId, String noteName, String noteDate, String noteText){
        this.noteId = noteId;
        this.noteName = noteName;
        this.noteDate = noteDate;
        this.noteText = noteText;
    }*/

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText){this.noteText = noteText;}

    public long getNoteId() {
        return this.noteId;
    }

    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

    public String getNoteName() {
        return this.noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteDate() {
        return this.noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }
}
