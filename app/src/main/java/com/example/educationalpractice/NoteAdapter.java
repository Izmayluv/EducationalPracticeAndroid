package com.example.educationalpractice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Note> notes;
    private Context context;

    NoteAdapter(Context context, List<Note> notes){
        this.notes = notes;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
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
        holder.textViewNoteDate.setText(note.getNoteDate());
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
                    int positionId = getAdapterPosition();

                    Intent i = new Intent(v.getContext(), NoteEditActivity.class);
                    i.putExtra("ViewHolderID", positionId);
                    v.getContext().startActivity(i);
                }
            });
        }

    }
}
