package com.example.educationalpractice;

public class Note {

    private final String noteName;
    private final String noteDate;

    public Note(String noteName, String noteDate){
        this.noteName = noteName;
        this.noteDate = noteDate;
    }

    public String getNoteDate() {
        return this.noteDate;
    }

    public String getNoteName() {
        return this.noteName;
    }
}
