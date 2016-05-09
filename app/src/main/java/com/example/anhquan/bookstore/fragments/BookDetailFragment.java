package com.example.anhquan.bookstore.fragments;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anhquan.bookstore.Entity.book.Book;
import com.example.anhquan.bookstore.R;
import com.example.anhquan.bookstore.Services.ServiceGenerator;
import com.example.anhquan.bookstore.Services.StartFragment;
import com.example.anhquan.bookstore.Services.Store;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by AnhQuan on 05/05/2016.
 */
public class BookDetailFragment extends Fragment {
    public Book book;
    public void addElement(Book book){
        this.book=book;
    }
    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.book_detail, container, false);
        TextView title=(TextView) v.findViewById(R.id.tvTitleDetail);
        title.setText(book.getTitle());

        TextView author=(TextView) v.findViewById(R.id.tvAuthorDetail);
        author.setText(book.getAuthor());

        TextView publishSher=(TextView) v.findViewById(R.id.tvPublishSherDetail);
        publishSher.setText(book.getPublisher());

        TextView publishYear=(TextView) v.findViewById(R.id.tvPulishYear);
        publishYear.setText(book.getPublishYear());

        TextView originPrice=(TextView) v.findViewById(R.id.tvOriginalPriceDetail);
        originPrice.setText(book.getOriginalPrice());

        TextView des=(TextView) v.findViewById(R.id.tvDesDetail);
        des.setText(book.getDescription());

        ImageView image=(ImageView) v.findViewById(R.id.ivImageBookDetail);
        Picasso.with(v.getContext()).load(ServiceGenerator.API_BASE_URL+"resources/image/thumb/"+book.getImage()).resize(500,651).into(image);

        final Button btnaddToCart=(Button)v.findViewById(R.id.btnAddToCart);
        Button btnOrder=(Button)v.findViewById(R.id.btnOrder);
        btnOrder.setText("Mua ngay với "+book.getSalePrice()+" đ");

        ArrayList<Book> books=new Store().getCart(v.getContext());
        for(int i=0; i<books.size();i++){
            if(books.get(i).getIdBook()==book.getIdBook()){
                btnaddToCart.setEnabled(false);
                btnaddToCart.setText("Đã trong rỏ hàng");
                btnaddToCart.setBackgroundResource(R.drawable.button_notaddtocart);
                btnaddToCart.setTextColor(getResources().getColor(R.color.accent_500));
                break;
            }
        }
        btnaddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Store().addElementToCart(v.getContext(),book);
                btnaddToCart.setEnabled(false);
                btnaddToCart.setText("Đã trong rỏ hàng");
                btnaddToCart.setBackgroundResource(R.drawable.button_notaddtocart);
                btnaddToCart.setTextColor(getResources().getColor(R.color.accent_500));
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderFragment fragment=new OrderFragment();
                fragment.addElement(book);
                StartFragment.show(fragment,v);
            }
        });

        return v;
    }
}
