package com.example.anhquan.bookstore.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anhquan.bookstore.Entity.book.Book;
import com.example.anhquan.bookstore.R;

/**
 * Created by AnhQuan on 05/05/2016.
 */
public class OrderFragment extends Fragment {
    public Book book;

    public void addElement(Book book) {
        this.book = book;
    }

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.order_fragment, container, false);

        return v;
    }
}