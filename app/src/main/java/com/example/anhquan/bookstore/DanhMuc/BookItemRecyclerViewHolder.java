package com.example.anhquan.bookstore.DanhMuc;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anhquan.bookstore.Entity.book.Book;
import com.example.anhquan.bookstore.MainActivity;
import com.example.anhquan.bookstore.R;
import com.example.anhquan.bookstore.fragments.BookDetailFragment;
import com.example.anhquan.bookstore.fragments.QuanLyRoHang.RoHangLuuFragment;

/**
 * Created by AnhQuan on 02/05/2016.
 */
public class BookItemRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView tvNameBook;
    public TextView tvPrice;
    public ImageView ivImageBook;
    public View view;
    public Book book=new Book();
    public BookItemRecyclerViewHolder(final View itemView) {
        super(itemView);
        this.view=itemView;
        tvNameBook= (TextView) itemView.findViewById(R.id.tvNameBook);
        tvPrice= (TextView) itemView.findViewById(R.id.tvPrice);
        ivImageBook =(ImageView) itemView.findViewById(R.id.ivImageBook);

        tvNameBook.setOnClickListener(this);
        tvPrice.setOnClickListener(this);
        ivImageBook.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        BookDetailFragment fragment=new BookDetailFragment();
        fragment.addElement(book);
        String backStateName = fragment.getClass().getName();
        String fragmentTag = backStateName;

        MainActivity activity= (MainActivity) view.getContext();
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
}
