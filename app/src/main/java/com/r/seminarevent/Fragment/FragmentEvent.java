package com.r.seminarevent.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.r.seminarevent.Adapter.EventStoryFragment;
import com.r.seminarevent.R;

/**
 * Created by Unknown on 3/20/2018.
 */

public class FragmentEvent extends Fragment {

    TabLayout tab;
    ViewPager fragmentVP;
    TabLayout.Tab tabScan, tabHistory;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_story, container, false);
        initialVariable(view);
        tabSetup(view);
        fragmentSetup(view);
        return view;
    }

    private void initialVariable(View view) {
        tab = (TabLayout) view.findViewById(R.id.eventStoryTL);
        fragmentVP = (ViewPager) view.findViewById(R.id.eventStoryContainer);
    }

    private void tabSetup(View view){
        tabScan = tab.newTab();
        tabScan.setText("Scan Event");
        tab.addTab(tabScan, true);

        tabHistory = tab.newTab();
        tabHistory.setText("Event History");
        tab.addTab(tabHistory);

        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentVP.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void fragmentSetup(View view){
        EventStoryFragment eventStoryFragment = new EventStoryFragment(getChildFragmentManager());
        fragmentVP.setAdapter(eventStoryFragment);
        fragmentVP.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        tabScan.select();
                        break;
                    case 1:
                        tabHistory.select();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents() == null){
                Toast.makeText(getActivity(), "You cancelled the scanner", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), result.getContents(), Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

//    textView = (TextView) view.findViewById(R.id.seminarEventQRTV);
//        textView.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
//            intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
//            intentIntegrator.setBeepEnabled(false);
//            intentIntegrator.setBarcodeImageEnabled(false);
//            intentIntegrator.setCameraId(0);
//            intentIntegrator.setPrompt("Scan");
//            intentIntegrator.initiateScan();
//        }
//    });
}
