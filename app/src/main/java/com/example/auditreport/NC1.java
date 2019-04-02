package com.example.auditreport;

import android.content.res.Resources;

import java.util.ArrayList;

import charts.PieChartActivity;

public class NC1 {
    private String name;
        private Class activityClass;

        private NC1(String name, Class activityClass) {
            this.name = name;
            this.activityClass = activityClass;
        }

        public String getName() {
            return name;
        }

        Class getActivityClass() {
            return activityClass;
        }

        static ArrayList<NC1> createNC1List(Resources resources) {
            ArrayList<NC1> nc1List = new ArrayList<>();

            nc1List.add(new NC1(resources.getString(R.string.pie_chart), PieChartActivity.class));

            return nc1List;
        }

}

