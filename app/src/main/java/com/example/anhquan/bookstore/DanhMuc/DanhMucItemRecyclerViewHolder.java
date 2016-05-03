package com.example.anhquan.bookstore.DanhMuc;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.anhquan.bookstore.R;

/**
 * Created by AnhQuan on 04/05/2016.
 */
public class DanhMucItemRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView tvDanhMuc;
    public TextView tvThem;
    public RecyclerView recyclerView;

    public DanhMucItemRecyclerViewHolder(final View itemView) {
        super(itemView);
        tvDanhMuc = (TextView) itemView.findViewById(R.id.tvDanhMuc);
        tvThem = (TextView) itemView.findViewById(R.id.tvThem);
        recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerDanhMuc);
    }
}
