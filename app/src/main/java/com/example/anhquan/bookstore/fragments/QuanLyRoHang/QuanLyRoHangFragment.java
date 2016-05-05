package com.example.anhquan.bookstore.fragments.QuanLyRoHang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anhquan.bookstore.R;
import com.example.anhquan.bookstore.Services.Store;
import com.example.anhquan.bookstore.ViewPagerAdapter;
import com.example.anhquan.bookstore.fragments.ListBookFragment;

public class QuanLyRoHangFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    RoHangFragment roHangFragment;
    RoHangLuuFragment roHangLuuFragment;
    DonHangFragment donHangFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_one, container, false);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        return v;
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        roHangFragment = new RoHangFragment();

        ListBookFragment listBookFragment=new ListBookFragment();
        listBookFragment.addElement("List sach da luu",new Store().getCart(viewPager.getContext()));

        roHangLuuFragment = new RoHangLuuFragment();
        donHangFragment = new DonHangFragment();
        adapter.addFragment(listBookFragment, "Rỏ hàng");
        adapter.addFragment(roHangLuuFragment, "Rỏ hàng đã lưu");
        adapter.addFragment(donHangFragment, "Đơn đặt hàng");
        viewPager.setAdapter(adapter);
    }
}
