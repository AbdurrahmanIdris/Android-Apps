package eg.edu.edraak.sqlitedemoapp;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder>{
    public List<Note> notesList;
    private Context context;

    public NoteAdapter(Context context, List<Note> notesList){
        this.context = context;
        this.notesList = notesList;
    }//end Constructor
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView note, dot, timestamp;

        public MyViewHolder(View view) {
            super(view);
            note = itemView.findViewById(R.id.noteView);
            dot = itemView.findViewById(R.id.dot);
            timestamp = itemView.findViewById(R.id.timestamp);
        }//end of constructor
    }//end class of MyViewHolder

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_row, parent, false);
        return new MyViewHolder(itemView);
    }//end of onCreateViewHolder

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Note note = notesList.get(position);
        holder.note.setText(note.getNote());
        holder.dot.setText(Html.fromHtml("4#8226;"));
        holder.timestamp.setText(formatDate(note.getTimestamp()));
    }//end of onBindViewHolder

    @Override
    public int getItemCount() {
        return notesList.size();
    }//end getItemCount <it returns how many books in my booksList>

    private String formatDate(String dateStr){
        try{
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtout = new SimpleDateFormat("MM d");
            return fmtout.format(date);
        }//end try
        catch (ParseException e){}//end catch
        return "";
    }//end formatDate
}//end class
