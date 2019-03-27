package com.example.auditreport;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;

import android.support.v4.content.ContextCompat;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;



public class TabForm extends AppCompatActivity {

   // private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_form);
      //  toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle(getResources().getString(R.string.app_name));
      //  setSupportActionBar(toolbar);

        // create tablayouts

        tabLayout = findViewById(R.id.tablayout);
        TabItem tabPM = findViewById(R.id.tabPM);
        TabItem tabSE = findViewById(R.id.tabSE);
        final TabItem tabDev = findViewById(R.id.tabDev);
        TabItem tabQA = findViewById(R.id.tabQA);
        viewPager = findViewById(R.id.viewPager);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

         tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
             @Override
             public void onTabSelected(TabLayout.Tab tab) {
                 viewPager.setCurrentItem(tab.getPosition());

                 if (tab.getPosition() == 1) {
                    // toolbar.setBackgroundColor(ContextCompat.getColor(TabForm.this,
                      //       R.color.systemsorange));
                     tabLayout.setBackgroundColor(ContextCompat.getColor(TabForm.this,
                             R.color.systemsorange));
                     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                         getWindow().setStatusBarColor(ContextCompat.getColor(TabForm.this,
                                 R.color.systemsorange));
                     }
                 } else if (tab.getPosition() == 2) {
                   //  toolbar.setBackgroundColor(ContextCompat.getColor(TabForm.this,
                     //        R.color.systemsorange));
                     tabLayout.setBackgroundColor(ContextCompat.getColor(TabForm.this,
                             R.color.systemsorange));
                     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                         getWindow().setStatusBarColor(ContextCompat.getColor(TabForm.this,
                                 R.color.systemsorange));
                     }
                 }else if (tab.getPosition() == 0) {
                     //toolbar.setBackgroundColor(ContextCompat.getColor(TabForm.this,
                       //      R.color.systemsorange));
                     tabLayout.setBackgroundColor(ContextCompat.getColor(TabForm.this,
                             R.color.systemsorange));
                     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                         getWindow().setStatusBarColor(ContextCompat.getColor(TabForm.this,
                                 R.color.systemsorange));
                     }
                 }
                 else if (tab.getPosition() == 3) {
                     //toolbar.setBackgroundColor(ContextCompat.getColor(TabForm.this,
                       //      R.color.systemsorange));
                     tabLayout.setBackgroundColor(ContextCompat.getColor(TabForm.this,
                             R.color.systemsorange));
                     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                         getWindow().setStatusBarColor(ContextCompat.getColor(TabForm.this,
                                 R.color.systemsorange));
                     }
                 }
                 else {
                     //toolbar.setBackgroundColor(ContextCompat.getColor(TabForm.this,
                       //      R.color.colorPrimary));
                     tabLayout.setBackgroundColor(ContextCompat.getColor(TabForm.this,
                             R.color.colorPrimary));
                     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                         getWindow().setStatusBarColor(ContextCompat.getColor(TabForm.this,
                                 R.color.colorPrimary));
                     }
                 }
             }

             @Override
             public void onTabUnselected(TabLayout.Tab tab) {

             }

             @Override
             public void onTabReselected(TabLayout.Tab tab) {

             }
         });







    }

}
