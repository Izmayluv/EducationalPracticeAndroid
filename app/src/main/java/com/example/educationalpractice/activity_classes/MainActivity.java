package com.example.educationalpractice.activity_classes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.educationalpractice.classes.Note;
import com.example.educationalpractice.R;
import com.example.educationalpractice.classes.NoteRecycleViewAdapter;
import com.example.educationalpractice.room.NoteDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.list);
        FloatingActionButton floatingButtonAddNote = findViewById(R.id.floatingActionButton);

        NoteDatabase db = NoteDatabase.getINSTANCE(getApplicationContext());
        notes = db.noteDAO().getAll();

       recyclerView.setAdapter(new NoteRecycleViewAdapter(this, notes));
        db.close();

        floatingButtonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NoteEditActivity.class);
                i.putExtra("NewNote", true);
                startActivity(i);
            }
        });
    }
}