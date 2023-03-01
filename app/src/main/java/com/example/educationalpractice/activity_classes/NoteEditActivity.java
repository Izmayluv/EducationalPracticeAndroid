package com.example.educationalpractice.activity_classes;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.EditText;

import com.example.educationalpractice.NoteDB;
import com.example.educationalpractice.R;
import com.example.educationalpractice.classes.Note;
import com.example.educationalpractice.room.NoteDAO;
import com.example.educationalpractice.room.NoteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class NoteEditActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);

        EditText editTextNoteName = findViewById(R.id.editTextNoteName);
        EditText editTextNoteText = findViewById(R.id.editTextNoteText);

        SimpleDateFormat currentDate = new SimpleDateFormat("dd MMMM", new Locale("ru", "ru"));
        String currentDateStr = currentDate.format(new Date());


        Bundle arguments = getIntent().getExtras();
        if(arguments!=null){
            if(arguments.containsKey("ViewHolderID")){
                long id = arguments.getInt("ViewHolderID");
                NoteDatabase db = NoteDatabase.getINSTANCE(getApplicationContext());
                Note note = new Note();
                note.setNoteId(id);
                note.setNoteName(editTextNoteName.getText().toString());
                note.setNoteText(editTextNoteText.getText().toString());
                db.noteDAO().insertNewNote(note);
            }
            if(arguments.containsKey("NewNote")){
                NoteDatabase db = NoteDatabase.getINSTANCE(getApplicationContext());
                Note note = new Note();
                note.setNoteName(editTextNoteName.getText().toString());
                note.setNoteText(editTextNoteText.getText().toString());
                note.setNoteDate(currentDateStr);
                db.noteDAO().insertNewNote(note);
            }
        }



    }
}