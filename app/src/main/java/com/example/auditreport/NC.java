package com.example.auditreport;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;
public class NC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nc);


        ArrayList<NCList> ncList = GetNCList();

        final ListView lv = (ListView) findViewById(R.id.srListView);
        lv.setAdapter(new NCBaseAdapter(this, ncList));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv.getItemAtPosition(position);
                NCList fullObject = (NCList) o;
            }
        });
    }

    private ArrayList<NCList> GetNCList() {

        ArrayList<NCList> results = new ArrayList<NCList>();

        SharedPreferences preferences = getSharedPreferences("preference_name",
                Context.MODE_PRIVATE);
        String value = preferences.getString("no_of_nc", "");
        assert value != null;
        int int_value = Integer.parseInt(value);

        for (int i = 0; i < int_value; i++) {
            NCList sr = new NCList();
            sr.setNc_summ("AB");
            sr.setType("San Francisco, CA");
            sr.setOwner("415-555-1234");
            results.add(sr);

        }
        return results;

    }

}




