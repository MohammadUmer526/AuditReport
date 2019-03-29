package com.example.auditreport;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;


import android.support.v4.content.ContextCompat;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;



public class TabForm extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ActionBar toolbar;
    private Button btn_next_tab, btn_prev_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_form);



        tabLayout = findViewById(R.id.tablayout);
        TabItem tabPrev = findViewById(R.id.tab_prev);
        TabItem tabPM = findViewById(R.id.tabPM);
        TabItem tabSE = findViewById(R.id.tabSE);
        TabItem tabDev = findViewById(R.id.tabDev);
        TabItem tabQA = findViewById(R.id.tabQA);
        TabItem tabNxt = findViewById(R.id.tab_next);
        viewPager = findViewById(R.id.viewPager);




        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
      //  viewPager.setAdapter(pagerAdapter);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setAdapter(pagerAdapter);


         tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
             @Override
             public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 5){
                    Intent ab = new Intent(TabForm.this, NC.class);
                    startActivity(ab);

                }else if (tab.getPosition() == 0) {
                    onBackPressed();
                }else {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                if (tab.getPosition() == 1) {
                     tabLayout.setBackgroundColor(ContextCompat.getColor(TabForm.this,
                             R.color.systemsorange));
                     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                         getWindow().setStatusBarColor(ContextCompat.getColor(TabForm.this,
                                 R.color.systemsorange));
                     }
                 }
                 else if (tab.getPosition() == 2) {

                     tabLayout.setBackgroundColor(ContextCompat.getColor(TabForm.this,
                             R.color.systemsorange));
                     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                         getWindow().setStatusBarColor(ContextCompat.getColor(TabForm.this,
                                 R.color.systemsorange));
                     }
                 } else if (tab.getPosition() == 3) {

                     tabLayout.setBackgroundColor(ContextCompat.getColor(TabForm.this,
                             R.color.systemsorange));
                     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                         getWindow().setStatusBarColor(ContextCompat.getColor(TabForm.this,
                                 R.color.systemsorange));
                     }
                 } else if (tab.getPosition() == 4) {

                     tabLayout.setBackgroundColor(ContextCompat.getColor(TabForm.this,
                             R.color.systemsorange));
                     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                         getWindow().setStatusBarColor(ContextCompat.getColor(TabForm.this,
                                 R.color.systemsorange));
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
