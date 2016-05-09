package com.example.anhquan.bookstore.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anhquan.bookstore.Entity.book.Book;
import com.example.anhquan.bookstore.R;
import com.example.anhquan.bookstore.Services.StartFragment;

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

        View v = inflater.inflate(R.layout.order_fragment, container, false);
        TextView tvTitle = (TextView) v.findViewById(R.id.tvTitleOrder);
        EditText txtName = (EditText) v.findViewById(R.id.txtNameOrder);
        EditText txtAddress = (EditText) v.findViewById(R.id.txtAddressOrder);
        EditText txtPhone = (EditText) v.findViewById(R.id.txtPhoneOrder);
        EditText txtNumber = (EditText) v.findViewById(R.id.txtNumberOrder);
        Button btnOrder = (Button) v.findViewById(R.id.btnOrder_Order);

        tvTitle.setText(book.getTitle());
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(v.getContext(), "Đặt hàng thành công", Toast.LENGTH_SHORT);
                Snackbar.make(v, "Đặt hàng thành công", Snackbar.LENGTH_SHORT).show();
                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                StartFragment.show(new HomeFragment(), v);
                            }
                        }, 2000);

            }
        });

        return v;
    }
}