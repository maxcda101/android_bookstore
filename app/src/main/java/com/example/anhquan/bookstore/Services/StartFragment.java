package com.example.anhquan.bookstore.Services;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.anhquan.bookstore.MainActivity;
import com.example.anhquan.bookstore.R;

/**
 * Created by AnhQuan on 05/05/2016.
 */
public class StartFragment {
    public static void show(Fragment fragment,View view ){;
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
