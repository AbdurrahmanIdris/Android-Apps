package eg.edu.edraak.recyclerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jo.edu.edrak.android.sqlightdatabase.RecyclerTouchListener;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BookAdapter myAdapter;
    List<Book> booksList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        myAdapter = new BookAdapter(booksList);
        RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(myAdapter);
        prepareBooksData();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(
                getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Book book = booksList.get(position);
                Toast.makeText(getApplicationContext(),"Selected item is " + book.getTitle(), Toast.LENGTH_LONG).show();
            }//end onClick

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }//end of onCreate

    void prepareBooksData(){
        Book book = new Book("Rich dad Poor dad","Robert Kawasaki","2005");
        booksList.add(book);
        Book book1 = new Book("ML4D","Daniel","2010");
        booksList.add(book1);
        Book book2 = new Book("The Quran Answer","Mohab Elsaeed","2017");
        booksList.add(book2);

        myAdapter.notifyDataSetChanged();
    }//end of prepareBooksData

}//end class
