package com.example.educationalpractice.classes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.educationalpractice.R;
import com.example.educationalpractice.activity_classes.NoteEditActivity;

import java.util.List;

public class NoteRecycleViewAdapter extends RecyclerView.Adapter<NoteRecycleViewAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Note> notes;

    public NoteRecycleViewAdapter(Context context, List<Note> notes){
        this.notes = notes;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NoteRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = inflater.inflate(R.layout.note_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteRecycleViewAdapter.ViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.textViewNoteName.setText(note.getNoteName());
        holder.textViewNoteDate.setText(note.getNoteDate());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class ViewHolder  extends  RecyclerView.ViewHolder{

        private final TextView textViewNoteName, textViewNoteDate;

        public ViewHolder(@NonNull View view) {
            super(view);

            textViewNoteName = view.findViewById(R.id.textViewNoteName);
            textViewNoteDate = view.findViewById(R.id.textViewNoteDate);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    long positionId = getAdapterPosition();

                    Intent i = new Intent(v.getContext(), NoteEditActivity.class);
                    i.putExtra("ViewHolderID", positionId);
                    v.getContext().startActivity(i);
                }
            });
        }

    }
}
