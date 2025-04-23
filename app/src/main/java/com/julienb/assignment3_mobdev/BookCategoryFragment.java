package com.julienb.assignment3_mobdev;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookCategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookCategoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private BookCategoryAdapter adapter;

    private List<String> categories = Arrays.asList("Autobiography", "Fiction", "Comic", "Self-help");
    private List<Integer> categoryImg = Arrays.asList(R.drawable.autobiography_banner, R.drawable.fictional, R.drawable.comics, R.drawable.self_help);

    public BookCategoryFragment() {
        // Required empty public constructor
    }


    public static BookCategoryFragment newInstance() {
        BookCategoryFragment fragment = new BookCategoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_book_category, container, false);

        recyclerView = view.findViewById(R.id.category_recycler);
        adapter = new BookCategoryAdapter(categories, categoryImg, category -> {
            BookListFragment listFragment = (BookListFragment) getParentFragmentManager().findFragmentById(R.id.list_container);
            if (listFragment != null) {
                listFragment.updateBookList(category);
            }
        });

        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);

        return view;
    }
}