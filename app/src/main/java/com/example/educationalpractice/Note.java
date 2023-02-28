package com.example.educationalpractice;

public class Note {

    private final String noteName;
    private final String noteDate;
    private final String noteId;

    public Note(String noteId, String noteName, String noteDate){
        this.noteId = noteId;
        this.noteName = noteName;
        this.noteDate = noteDate;
    }

    public String getNoteId() {
        return this.noteId;
    }

    public String getNoteName() {
        return this.noteName;
    }

    public String getNoteDate() {
        return this.noteDate;
    }

}
