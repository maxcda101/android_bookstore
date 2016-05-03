package com.example.anhquan.bookstore.DanhMuc;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anhquan.bookstore.Entity.book.Book;
import com.example.anhquan.bookstore.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AnhQuan on 02/05/2016.
 */
public class BookCustomRecyclerAdapter extends
        RecyclerView.Adapter<BookItemRecyclerViewHolder> {
    private List<Book> listData = new ArrayList<Book>();

    public BookCustomRecyclerAdapter(List<Book> listData) {
        this.listData = listData;
    }

    public void updateList(List<Book> data) {
        listData = data;
        notifyDataSetChanged();
    }
    @Override
    public BookItemRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.item_book, viewGroup, false);
        return new BookItemRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BookItemRecyclerViewHolder holder, int position ) {
        holder.tvNameBook.setText(listData.get(position).getTitle());
        holder.tvPrice.setText(listData.get(position).getSalePrice()+"");

        Picasso.with(holder.view.getContext()).load(listData.get(position).getImage())
                .resize(150,200)
                .into(holder.ivImageBook);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
    public void addItem(int position, Book book) {
        listData.add(position, book);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}
