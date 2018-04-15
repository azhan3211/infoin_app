package com.r.seminarevent.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.r.seminarevent.Adapter.OpeningFragment;
import com.r.seminarevent.R;

import java.util.Timer;

public class Opening extends AppCompatActivity implements View.OnClickListener {

    ImageView logo;
    TextView skip, next;
    ViewPager openingVP;
    RelativeLayout openingInformation;
    LinearLayout dotOpening;
    ImageView[] dots = new ImageView[4];
    int currentItem = 0;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    static String PREF_NAME = "opening";
    static String PREF_INFO = "information";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opening_layout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initialVariable();
        logoOpeing();
        setupOpeningFragment();
        dotOpening();
        next.setOnClickListener(this);
        skip.setOnClickListener(this);
    }

    private void checkingFirstInstallApp(){
        sharedPreferences = getSharedPreferences(PREF_NAME, Opening.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if(sharedPreferences.contains(PREF_INFO)){
            Intent intent = new Intent(Opening.this, Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        } else {
            editor.putBoolean(PREF_INFO, true);
            editor.commit();
            openingInformation.setVisibility(View.VISIBLE);
        }
    }

    private void initialVariable(){
        logo = (ImageView) findViewById(R.id.logoIV);
        skip = (TextView) findViewById(R.id.skipTV);
        next = (TextView) findViewById(R.id.nextTV);
        openingVP = (ViewPager) findViewById(R.id.fragmentOpening);
        openingInformation = (RelativeLayout) findViewById(R.id.openingInformation);
        dotOpening = (LinearLayout) findViewById(R.id.dotOpening);
    }

    private void dotOpening(){
        for(int i = 0; i < 4; i++){
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(Opening.this, R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,0,0);
            dotOpening.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(Opening.this, R.drawable.active_dot));

        openingVP.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i < 4; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(Opening.this, R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(Opening.this, R.drawable.active_dot));
                currentItem = position;
                if(currentItem == 4)
                    currentItem = 0;
                if(currentItem == 0){
                    skip.setTextColor(Color.parseColor("#FFFFFF"));
                    next.setTextColor(Color.parseColor("#FFFFFF"));
                } else if(currentItem < 4){
                    skip.setTextColor(Color.parseColor("#6BCDFD"));
                    next.setTextColor(Color.parseColor("#6BCDFD"));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupOpeningFragment(){
        OpeningFragment openingFragment = new OpeningFragment(getSupportFragmentManager(), 4);
        openingVP.setAdapter(openingFragment);
    }

    private void logoOpeing(){
        Handler handler = new Handler();

        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                logo.setVisibility(View.GONE);
                checkingFirstInstallApp();
            }
        },3000);


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Opening.this, Login.class);
        switch (view.getId()){
            case R.id.nextTV:
                currentItem++;
                if(currentItem == 4) {
                    startActivity(intent);
                    finish();
                }
                if(currentItem == 0){
                    skip.setTextColor(Color.parseColor("#FFFFFF"));
                    next.setTextColor(Color.parseColor("#FFFFFF"));
                } else if(currentItem < 4){
                    skip.setTextColor(Color.parseColor("#6BCDFD"));
                    next.setTextColor(Color.parseColor("#6BCDFD"));
                }
                openingVP.setCurrentItem(currentItem);
                break;
            case R.id.skipTV:
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
}