package com.example.khant.myanmarese;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import adapter.TabViewpagerAdapter;

public class TimeAndDateActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TabViewpagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_and_date);

        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        adapter = new TabViewpagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        /*attach with tab*/
        tabLayout.setupWithViewPager(viewPager);

    }


}
