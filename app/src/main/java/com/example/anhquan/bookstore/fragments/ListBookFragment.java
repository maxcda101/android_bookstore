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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anhquan.bookstore.Entity.book.Book;
import com.example.anhquan.bookstore.MainActivity;
import com.example.anhquan.bookstore.R;
import com.example.anhquan.bookstore.Services.ServiceGenerator;
import com.example.anhquan.bookstore.Services.StartFragment;
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

        gvBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BookDetailFragment fragment=new BookDetailFragment();
                fragment.addElement(listBook.get(position));
                StartFragment.show(fragment,view);
            }
        });

        return v;
    }
}
class ListBookAdapter extends BaseAdapter {
    private List<Book> listBook=new ArrayList<>();
    private Context context;
    public Book book=new Book();

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

            book=listBook.get(position);
            Picasso.with(v.getContext()).load(ServiceGenerator.API_BASE_URL+"resources/image/thumb/"+listBook.get(position).getImage())
                    .resize(500,651)
                    .into(image);

        }else{
            v=convertView;
        }
        return v;
    }

}