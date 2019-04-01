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
              return new QATab();
            case 1:
                return new PMTab();
            case 2:
                return new SETab();

            case 3:
                return new SETab();

            case 4:
                return new QATab();

            case 5:
                return new NextTab();
                default:
                    return null;

        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
