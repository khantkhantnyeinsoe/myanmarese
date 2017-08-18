package com.example.khant.myanmarese;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adapter.BodyPartspagerAdapter;
import adapter.TabViewpagerAdapter;

public class BodyPartsActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    BodyPartspagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_parts);

        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new BodyPartspagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        /*attach with tab*/
        tabLayout.setupWithViewPager(viewPager);
    }
}
