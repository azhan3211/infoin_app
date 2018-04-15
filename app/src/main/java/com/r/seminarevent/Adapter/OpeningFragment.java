package com.r.seminarevent.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.r.seminarevent.Fragment.FragmentOpening1;
import com.r.seminarevent.Fragment.FragmentOpening2;
import com.r.seminarevent.Fragment.FragmentOpening3;
import com.r.seminarevent.Fragment.FragmentOpening4;

public class OpeningFragment extends FragmentPagerAdapter {

    int itemCount;

    public OpeningFragment(FragmentManager fm, int itemCount) {
        super(fm);
        this.itemCount = itemCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentOpening1();
            case 1:
                return new FragmentOpening2();
            case 2:
                return new FragmentOpening3();
            case 3:
                return new FragmentOpening4();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return itemCount;
    }
}