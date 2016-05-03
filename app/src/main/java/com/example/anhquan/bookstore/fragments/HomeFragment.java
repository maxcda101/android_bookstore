package com.example.anhquan.bookstore.fragments;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anhquan.bookstore.DanhMuc.BookCustomRecyclerAdapter;
import com.example.anhquan.bookstore.DanhMuc.DanhMucCustomRecyclerAdapter;
import com.example.anhquan.bookstore.Entity.book.Book;
import com.example.anhquan.bookstore.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AnhQuan on 02/05/2016.
 */
public class HomeFragment extends Fragment {
    ArrayList<String> listDanhMuc=new ArrayList<String>();
    ArrayList<ArrayList<Book>> listSach=new ArrayList<ArrayList<Book>>();

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.home, container, false);
        RecyclerView recyclerView= (RecyclerView) v.findViewById(R.id.recyclerHome);
        ArrayList books=new ArrayList<Book>();
        for (int i=0; i<10;i++){
            Book book =new Book();
            book.setImage("http://www.grupodfg.com/dfg/sites/default/files/dfg-catalogo_0.jpeg");
            book.setSalePrice(100+i+"");
            book.setTitle("Title: "+i);
            books.add(book);
        }
        listDanhMuc.add("Top trong tuan");
        listDanhMuc.add("Top trong thang");
        listDanhMuc.add("Top trong nam");
        listSach.add(books);
        listSach.add(books);
        listSach.add(books);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        DanhMucCustomRecyclerAdapter adapter=new DanhMucCustomRecyclerAdapter(listDanhMuc,listSach);
        recyclerView.setAdapter(adapter);
        return v;
    }

}
