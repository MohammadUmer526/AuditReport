package com.example.auditreport;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    private final int numOfTabs;

    PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PMTab();
            case 1:
                return new SETab();

            case 2:
                return new DevTab();

            case 3:
                return new QATab();
                default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
