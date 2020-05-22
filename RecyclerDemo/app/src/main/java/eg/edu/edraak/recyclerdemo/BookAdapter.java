package eg.edu.edraak.recyclerdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder>{
    public List<Book> booksList;

    public BookAdapter(List<Book> booksList){
        this.booksList = booksList;
    }//end Constructor

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, author, year;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            author = itemView.findViewById(R.id.authorTxt);
            year = itemView.findViewById(R.id.yearTxt);
        }//end of constructor
    }//end class of MYViewHolder

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_row, parent, false);
        return new MyViewHolder(itemView);
    }//end of onCreateViewHolder

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Book book = booksList.get(position);
        holder.title.setText(book.getTitle());
        holder.author.setText(book.getAuthor());
        holder.year.setText(book.getYear());
    }//end of onBindViewHolder

    @Override
    public int getItemCount() {
        return booksList.size();
    }//end getItemCount <it returns how many books in my booksList>
}//end class
