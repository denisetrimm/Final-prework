package com.julienb.assignment3_mobdev;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class BookListFragment extends Fragment {

    private RecyclerView recyclerView;
    private BookListAdapter adapter;
    private List<Book> bookList = new ArrayList<>();


    public BookListFragment() {
        // Required empty public constructor
    }

    public static BookListFragment newInstance(String param1, String param2) {
        BookListFragment fragment = new BookListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_list, container, false);

        recyclerView = view.findViewById(R.id.book_list_recycler);
        adapter = new BookListAdapter(bookList, book -> {
//            Intent intent = new Intent(getContext(), DetailActivity.class);
//            intent.putExtra("BOOK_TITLE", book.getName());
//            intent.putExtra("BOOK_PRICE", book.getPrice());
//            startActivity(intent);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void updateBookList(String category) {
        bookList.clear();
        switch (category){
            case "Autobiography":
                bookList = DataSource.getAutobiography();
                break;

            case "Fiction":
                bookList = DataSource.getFiction();
                break;

            case "Comic":
                bookList = DataSource.getComics();
                break;

            case "Self-help":
                bookList = DataSource.getSelfHelpBook();
                break;
        }
        adapter.notifyDataSetChanged();
    }
}