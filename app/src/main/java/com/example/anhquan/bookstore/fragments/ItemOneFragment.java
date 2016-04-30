package com.example.anhquan.bookstore.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anhquan.bookstore.R;
import com.example.anhquan.bookstore.ViewPagerAdapter;

/**
 * Created by minhpq on 3/29/16.
 */
public class ItemOneFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    OneFragment oneFragment;
    TwoFragment twoFragment;
    ThreeFragment threeFragment;

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
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();
        adapter.addFragment(oneFragment, "ONE");
        adapter.addFragment(twoFragment, "TWO");
        adapter.addFragment(threeFragment, "THREE");
        viewPager.setAdapter(adapter);
    }
}
