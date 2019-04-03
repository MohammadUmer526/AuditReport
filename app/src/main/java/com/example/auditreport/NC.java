package com.example.auditreport;

import android.support.v7.app.ActionBar;
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
                //Toast.makeText(NC.this, "You have chosen: " + " " + fullObject.getNc_summ(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<NCList> GetNCList() {

        ArrayList<NCList> results = new ArrayList<NCList>();


        for (int i = 0; i < 4; i++) {
            NCList sr = new NCList();
            sr.setNc_summ("AB");
            sr.setType("San Francisco, CA");
            sr.setOwner("415-555-1234");
            results.add(sr);

        }
        return results;

    }

}




