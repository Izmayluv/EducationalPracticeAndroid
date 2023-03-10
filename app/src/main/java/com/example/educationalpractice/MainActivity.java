package com.example.educationalpractice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> notes = new ArrayList<>();
    String result;
    SimpleDateFormat currentDate;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentDate = new SimpleDateFormat("dd MMMM", new Locale("ru", "ru"));
        result = currentDate.format(new Date());

        setNotes();
        recyclerView = findViewById(R.id.list);
        recyclerView.setAdapter(new NoteAdapter(this, notes));
    }

    private void setNotes(){
        notes.add(new Note("1","Заметка", result));

    }
}