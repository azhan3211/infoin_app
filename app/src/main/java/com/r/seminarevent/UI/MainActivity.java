package com.r.seminarevent.UI;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.r.seminarevent.Fragment.FragmentAccount;
import com.r.seminarevent.Fragment.FragmentEvent;
import com.r.seminarevent.Fragment.FragmentHome;
import com.r.seminarevent.Fragment.FragmentSetting;
import com.r.seminarevent.R;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment = null;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Home");
        setContentView(R.layout.activity_main);
        initialVariable();
        tabSetup();
    }



    private void tabSetup() {
        //init tab
        TabLayout.Tab tabHome = tabLayout.newTab();
        tabHome.setText("Home");
        tabHome.setIcon(R.drawable.ic_home);
        tabHome.getIcon().setColorFilter(Color.parseColor("#228291"), PorterDuff.Mode.SRC_IN);
        tabLayout.addTab(tabHome, true);

        TabLayout.Tab tabEvent = tabLayout.newTab();
        tabEvent.setText("Event");
        tabEvent.setIcon(R.drawable.ic_event);
        tabEvent.getIcon().setColorFilter(Color.parseColor("#a9a9a9"), PorterDuff.Mode.SRC_IN);
        tabLayout.addTab(tabEvent);

        TabLayout.Tab tabAccount = tabLayout.newTab();
        tabAccount.setText("Account");
        tabAccount.setIcon(R.drawable.ic_account);
        tabAccount.getIcon().setColorFilter(Color.parseColor("#a9a9a9"), PorterDuff.Mode.SRC_IN);
        tabLayout.addTab(tabAccount);

        TabLayout.Tab tabSetting = tabLayout.newTab();
        tabSetting.setText("Setting");
        tabSetting.setIcon(R.drawable.ic_setting);
        tabSetting.getIcon().setColorFilter(Color.parseColor("#a9a9a9"), PorterDuff.Mode.SRC_IN);
        tabLayout.addTab(tabSetting);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#228291"), PorterDuff.Mode.SRC_IN);
                switch (tab.getPosition()){
                    case 0:
                        setTitle("Home");
                        fragment = new FragmentHome();
                        break;
                    case 1:
                        setTitle("Event");
                        fragment = new FragmentEvent();
                        break;
                    case 2:
                        setTitle("Account");
                        fragment = new FragmentAccount();
                        break;
                    case 3:
                        setTitle("Setting");
                        fragment = new FragmentSetting();
                        break;
                    default:
                        break;
                }
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainFragmentContainer, fragment);
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#a9a9a9"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initialVariable() {
        tabLayout = (TabLayout) findViewById(R.id.seminarEventTL);
        fragment = new FragmentHome();
        fragmentTransaction.replace(R.id.mainFragmentContainer, fragment);
        fragmentTransaction.commit();
    }
}
