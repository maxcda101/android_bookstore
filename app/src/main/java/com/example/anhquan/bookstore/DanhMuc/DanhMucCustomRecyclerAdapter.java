package com.example.anhquan.bookstore.DanhMuc;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anhquan.bookstore.Entity.book.Book;
import com.example.anhquan.bookstore.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AnhQuan on 03/05/2016.
 */
public class DanhMucCustomRecyclerAdapter extends
        RecyclerView.Adapter<DanhMucItemRecyclerViewHolder>{
    private List<String> listDanhMuc=new ArrayList<String>();
    private List<ArrayList<Book>> listSach=new ArrayList<ArrayList<Book>>();

    public DanhMucCustomRecyclerAdapter(List<String> listDanhMuc, List<ArrayList<Book>> listSach) {
        this.listDanhMuc = listDanhMuc;
        this.listSach = listSach;
    }
    public void updateList(List<String> listDanhMuc, List<ArrayList<Book>> listSach) {
        this.listDanhMuc = listDanhMuc;
        this.listSach = listSach;
        notifyDataSetChanged();
    }

    @Override
    public DanhMucItemRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.danhmuc_item, viewGroup, false);
        return new DanhMucItemRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DanhMucItemRecyclerViewHolder holder, int position) {
        holder.tvDanhMuc.setText(listDanhMuc.get(position)+ position);


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(holder.itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);
        holder.recyclerView.setLayoutManager(layoutManager);
        BookCustomRecyclerAdapter adapter=new BookCustomRecyclerAdapter(listSach.get(position));
        holder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return listDanhMuc.size();
    }
}
