package com.example.anhquan.bookstore.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anhquan.bookstore.Entity.book.Book;
import com.example.anhquan.bookstore.MainActivity;
import com.example.anhquan.bookstore.R;
import com.example.anhquan.bookstore.fragments.QuanLyRoHang.RoHangLuuFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AnhQuan on 04/05/2016.
 */
public class ListBookFragment extends Fragment {
    private String title;
    private ArrayList<Book> listBook=new ArrayList<>();
    public void addElement(String title, ArrayList<Book> listBook){
        this.title=title;
        this.listBook=listBook;

    }
    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.book_list, container, false);

        TextView tvTitle=(TextView) v.findViewById(R.id.tvTitleListBook);
        tvTitle.setText(title);

        GridView gvBook=(GridView) v.findViewById(R.id.gvListBook);
        ListBookAdapter adapter=new ListBookAdapter(listBook,v.getContext());
        gvBook.setAdapter(adapter);

        return v;
    }
}
class ListBookAdapter extends BaseAdapter implements View.OnClickListener{
    private List<Book> listBook=new ArrayList<>();
    private Context context;

    public ListBookAdapter(List<Book> listBook, Context context) {
        this.listBook = listBook;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listBook.size();
    }

    @Override
    public Object getItem(int position) {
        return listBook.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v;
        if(convertView==null){
            v=new View(context);
            v=inflater.inflate(R.layout.item_book, null);
            TextView title=(TextView) v.findViewById(R.id.tvNameBook);
            TextView price=(TextView) v.findViewById(R.id.tvPrice);
            ImageView image=(ImageView) v.findViewById(R.id.ivImageBook);

            title.setText(listBook.get(position).getTitle());
            price.setText(listBook.get(position).getSalePrice());

            Picasso.with(v.getContext()).load(listBook.get(position).getImage())
                    .resize(150,200)
                    .into(image);


            title.setOnClickListener(this);
            price.setOnClickListener(this);
            image.setOnClickListener(this);
        }else{
            v=convertView;
        }
        return v;
    }

    @Override
    public void onClick(View v) {
        RoHangLuuFragment fragment=new RoHangLuuFragment();
        String backStateName = fragment.getClass().getName();
        String fragmentTag = backStateName;

        MainActivity activity= (MainActivity) v.getContext();
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