package com.example.anhquan.bookstore.fragments.QuanLyRoHang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.anhquan.bookstore.R;

public class DonHangFragment extends Fragment {

    TextView tv;
    public DonHangFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        tv = (TextView) view.findViewById(R.id.tv_three);

        return view;
    }
}
