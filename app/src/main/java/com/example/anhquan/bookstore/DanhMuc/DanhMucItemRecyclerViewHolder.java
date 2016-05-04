package com.example.anhquan.bookstore.DanhMuc;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.anhquan.bookstore.Entity.book.Book;
import com.example.anhquan.bookstore.MainActivity;
import com.example.anhquan.bookstore.R;
import com.example.anhquan.bookstore.fragments.ListBookFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AnhQuan on 04/05/2016.
 */
public class DanhMucItemRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView tvDanhMuc;
    public TextView tvThem;
    public RecyclerView recyclerView;
    public ArrayList<Book> listSach=new ArrayList<Book>();

    public DanhMucItemRecyclerViewHolder(final View itemView) {
        super(itemView);
        tvDanhMuc = (TextView) itemView.findViewById(R.id.tvDanhMuc);
        tvThem = (TextView) itemView.findViewById(R.id.tvThem);
        recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerDanhMuc);
        //action
        tvThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListBookFragment fragment=new ListBookFragment();
                fragment.addElement(tvDanhMuc.getText()+"",listSach);
                String backStateName = fragment.getClass().getName();
                String fragmentTag = backStateName;

                MainActivity activity= (MainActivity) itemView.getContext();
                FragmentManager manager = activity.getSupportFragmentManager();
                boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

                if (!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null) { //fragment not in back stack, create it.
                    FragmentTransaction ft = manager.beginTransaction();
                    ft.replace(R.id.nav_contentframe, fragment, fragmentTag);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.addToBackStack(backStateName);
                    ft.commit();
                }
            }
        });
    }
}
