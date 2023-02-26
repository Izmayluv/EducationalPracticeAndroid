package com.example.educationalpractice;


import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private Context context;
    private final List<Note> notes;

    NoteAdapter(Context context, List<Note> notes){
        this.notes = notes;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = inflater.inflate(R.layout.note_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.textViewNoteName.setText(note.getNoteName());
        holder.textViewNoteDate.setText(note.getNoteDate().toString());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class ViewHolder  extends  RecyclerView.ViewHolder{
        final TextView textViewNoteName, textViewNoteDate;

        public ViewHolder(@NonNull View view) {
            super(view);
            textViewNoteName = view.findViewById(R.id.textViewNoteName);
            textViewNoteDate = view.findViewById(R.id.textViewNoteDate);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.getContext().startActivity(new Intent(v.getContext(), NoteEditActivity.class));
                }
            });
        }
    }
}
