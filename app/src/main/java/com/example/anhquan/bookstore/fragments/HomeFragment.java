package com.example.anhquan.bookstore.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.anhquan.bookstore.DanhMuc.DanhMucCustomRecyclerAdapter;
import com.example.anhquan.bookstore.Entity.book.Book;
import com.example.anhquan.bookstore.Entity.book.Category;
import com.example.anhquan.bookstore.R;
import com.example.anhquan.bookstore.Services.ServiceGenerator;
import com.example.anhquan.bookstore.Services.StartFragment;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AnhQuan on 02/05/2016.
 */
public class HomeFragment extends Fragment {
    ArrayList<String> listDanhMuc = new ArrayList<String>();
    ArrayList<ArrayList<Book>> listSach = new ArrayList<ArrayList<Book>>();

    RecyclerView recyclerView;
    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.home, container, false);
        recyclerView= (RecyclerView) v.findViewById(R.id.recyclerHome);
        ImageButton btnSearch=(ImageButton) v.findViewById(R.id.btnSearch);
        final EditText txtSearch=(EditText)v.findViewById(R.id.input_search);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                ServiceGenerator.BookStoreService bookStoreService=ServiceGenerator.createService(ServiceGenerator.BookStoreService.class);
                final String vl=txtSearch.getText()+"";
                Call<List<Book>> call=bookStoreService.searchBook(vl);
                call.enqueue(new Callback<List<Book>>() {
                    @Override
                    public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                        ListBookFragment listBookFragment=new ListBookFragment();
                        listBookFragment.addElement("Search: "+vl, (ArrayList<Book>) response.body());
                        StartFragment.show(listBookFragment, v);
                    }

                    @Override
                    public void onFailure(Call<List<Book>> call, Throwable t) {

                    }
                });

            }
        });

        if (listDanhMuc.size() == 0) {
            loadBooks();
            loadBookByCategory();

        }

        bindindRecylerView();


        return v;
    }

    public void loadBooks() {
        final ServiceGenerator.BookStoreService bookStoreService=ServiceGenerator.createService(ServiceGenerator.BookStoreService.class);
        Call<List<Book>> call=bookStoreService.get20newbooks();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                listSach.add((ArrayList<Book>) response.body());
                listDanhMuc.add("Sách mới phát hành");
                bindindRecylerView();

            }
            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });

    }
    public void loadBookByCategory(){
        final ServiceGenerator.BookStoreService bookStoreService=ServiceGenerator.createService(ServiceGenerator.BookStoreService.class);
        Call<List<Category>> call=bookStoreService.getAllCategory();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, final Response<List<Category>> response) {
                for(int i=0;i<response.body().size();i++){
                    Call<List<Book>> callBook=bookStoreService.getAllBookByCategory(response.body().get(i).getIdCategory());
                    final int finalI = i;
                    callBook.enqueue(new Callback<List<Book>>() {
                        @Override
                        public void onResponse(Call<List<Book>> call, Response<List<Book>> response2) {
                            listDanhMuc.add(response.body().get(finalI).getName());
                            listSach.add((ArrayList<Book>) response2.body());
                            bindindRecylerView();
                        }

                        @Override
                        public void onFailure(Call<List<Book>> call, Throwable t) {

                        }
                    });
                }
            }
            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });

    }

    public void bindindRecylerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        DanhMucCustomRecyclerAdapter adapter = new DanhMucCustomRecyclerAdapter(listDanhMuc, listSach);
        recyclerView.setAdapter(adapter);
    }

}
