package com.julienb.assignment3_mobdev;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookstoreFragmentContainer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookstoreFragmentContainer extends Fragment {

    public BookstoreFragmentContainer() {
        // Required empty public constructor
    }

    public static BookstoreFragmentContainer newInstance() {
        BookstoreFragmentContainer fragment = new BookstoreFragmentContainer();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookstore_container, container, false);

        FragmentManager fm = getChildFragmentManager();
        fm.beginTransaction().replace(R.id.category_container, new BookCategoryFragment()).commit();
        fm.beginTransaction().replace(R.id.list_container, new BookListFragment()).commit();

        return view;
    }
}