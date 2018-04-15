package com.r.seminarevent.Fragment;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.r.seminarevent.Adapter.SeminarEventAdapter;
import com.r.seminarevent.Adapter.SeminarEventKategoriAdapter;
import com.r.seminarevent.Adapter.SeminarEventVPAdapter;
import com.r.seminarevent.Model.SeminarEventData;
import com.r.seminarevent.R;
import com.r.seminarevent.UI.MainActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Unknown on 3/18/2018.
 */

public class FragmentHome extends Fragment {
    RecyclerView seminarEvent, seminarEventKategori;
    ViewPager seminarEventAd;
    RecyclerView.Adapter seminarEventAdapter, seminarEventKategoriAdapter;
    PagerAdapter seminarEventAdAdapter;
    List<SeminarEventData> seminarEventDatas;
    SeminarEventData seminarEventData;
    LinearLayout.LayoutParams layoutParams;
    LinearLayout linearLayout;
    ImageView[] dots;
    int currentPosition = 0;
    List<String> categories;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout, container,false);
        initialVariable(view);
        automaticVP();
        kategoriSetup();
        seminarEventSetup();
        dotSetup();
        return view;
    }

    private void seminarEventSetup(){
        for(int i = 0; i < 7; i++){
            seminarEventData = new SeminarEventData(
                    "Seminar IT #"+(i+1),
                    "2"+(i+1)+" Maret 2018",
                    "18:00 - 21:00"
            );
            seminarEventDatas.add(seminarEventData);
        }
        seminarEventAdapter = new SeminarEventAdapter(getActivity().getApplicationContext(), seminarEventDatas);
        seminarEvent.setAdapter(seminarEventAdapter);
    }

    private void dotSetup(){
        dots = new ImageView[seminarEventAdAdapter.getCount()];

        for(int i = 0; i < seminarEventAdAdapter.getCount(); i++){
            dots[i] = new ImageView(getActivity().getApplicationContext());
            dots[i].setImageResource(R.drawable.non_active_dot);
            layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            int right;
            right = (i+1 == seminarEventAdAdapter.getCount()) ?  0 : 8;
            layoutParams.setMargins(10,0,right,0);
            linearLayout.addView(dots[i], layoutParams);
        }
        dots[0].setImageResource(R.drawable.active_dot);

        seminarEventAd.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPosition = position;
                for(int i = 0; i < seminarEventAdAdapter.getCount(); i++){
                    dots[i].setImageResource(R.drawable.non_active_dot);
                }
                dots[position].setImageResource(R.drawable.active_dot);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void automaticVP(){
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currentPosition == seminarEventAdAdapter.getCount())
                    currentPosition = 0;
                seminarEventAd.setCurrentItem(currentPosition++, true);
            }
        };

        Timer autoVP = new Timer();
        autoVP.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 3000, 3000);
    }

    private void kategoriSetup() {
        for(int i = 0; i < 10; i++){
            categories.add("Kategori #"+(i+1));
        }
        seminarEventKategoriAdapter = new SeminarEventKategoriAdapter(categories);
        seminarEventKategori.setAdapter(seminarEventKategoriAdapter);
    }

    private void initialVariable(View view) {
        seminarEventDatas = new ArrayList<>();
        seminarEvent = (RecyclerView) view.findViewById(R.id.seminarEventRV);
        seminarEventKategori = (RecyclerView) view.findViewById(R.id.seminarEventKategoriRV);
        seminarEventKategori.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        categories = new ArrayList<>();

        //viewpager settings
        seminarEventAd = (ViewPager) view.findViewById(R.id.seminarEventAdVP);
        seminarEventAdAdapter = new SeminarEventVPAdapter(getActivity().getApplicationContext());
        seminarEventAd.setAdapter(seminarEventAdAdapter);

        linearLayout = (LinearLayout) view.findViewById(R.id.dotContainer);

        seminarEvent.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayout.HORIZONTAL, false));
        seminarEvent.setHasFixedSize(true);
    }
}
