package com.r.seminarevent.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.r.seminarevent.Fragment.FragmentEventHistory;
import com.r.seminarevent.Fragment.FragmentEventScan;

public class EventStoryFragment extends FragmentPagerAdapter {
    public EventStoryFragment(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentEventScan();
            case 1:
                return new FragmentEventHistory();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}