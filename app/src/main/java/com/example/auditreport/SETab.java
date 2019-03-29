package com.example.auditreport;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.EditText;
import android.widget.Spinner;


import net.cachapa.expandablelayout.ExpandableLayout;



public class SETab extends Fragment implements View.OnClickListener {

    private Spinner spinner_se_pi, spinner_se_pp, spinner_se_pm;
    private EditText edt_pi_points_attain, edt_pi_total_points;


    private ExpandableLayout expandableLayout_1, expandableLayout_2, expandableLayout_3;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_setab, container, false);

        expandableLayout_1 = rootView.findViewById(R.id.expandable_layout_1);
        expandableLayout_2 = rootView.findViewById(R.id.expandable_layout_2);
        expandableLayout_3 = rootView.findViewById(R.id.expandable_layout_3);

        spinner_se_pi = rootView.findViewById(R.id.spinner_se_pi);
        spinner_se_pp = rootView.findViewById(R.id.spinner_se_pp);
        spinner_se_pm = rootView.findViewById(R.id.spinner_se_pm);

        edt_pi_points_attain = rootView.findViewById(R.id.edt_pi_points_attain);
        edt_pi_total_points = rootView.findViewById(R.id.edt_pi_total_points);

        spinner_se_pi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub

                if (spinner_se_pi.getSelectedItem().toString().equals("Yes")) {
                    edt_pi_points_attain.setText("1");
                } else if (spinner_se_pi.getSelectedItem().toString().equals("No")) {
                    edt_pi_points_attain.setText("0");
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });







        expandableLayout_1.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
            @Override
            public void onExpansionUpdate(float expansionFraction, int state) {
                Log.d("ExpandableLayout0", "State: " + state);
            }
        });


        expandableLayout_2.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
            @Override
            public void onExpansionUpdate(float expansionFraction, int state) {
                Log.d("ExpandableLayout0", "State: " + state);
            }
        });


        expandableLayout_3.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
            @Override
            public void onExpansionUpdate(float expansionFraction, int state) {
                Log.d("ExpandableLayout0", "State: " + state);
            }
        });


        rootView.findViewById(R.id.expand_button_1).setOnClickListener(this);
        rootView.findViewById(R.id.expand_button_2).setOnClickListener(this);
        rootView.findViewById(R.id.expand_button_3).setOnClickListener(this);


        return rootView;




    }



    @Override
    public void onClick(View view) {

        edt_pi_points_attain = view.findViewById(R.id.edt_pi_points_attain);
        edt_pi_total_points = view.findViewById(R.id.edt_pi_total_points);



        if (view.getId() == R.id.expand_button_1) {
            if (expandableLayout_1.isExpanded()) {
                expandableLayout_1.collapse();
            } else {
                expandableLayout_1.expand();
            }
        } else if (view.getId() == R.id.expand_button_2) {

            if (expandableLayout_2.isExpanded()) {
                expandableLayout_2.collapse();
            } else {
                expandableLayout_2.expand() ;
            }
        } else if (view.getId() == R.id.expand_button_3) {
            if (expandableLayout_3.isExpanded()) {
                expandableLayout_3.collapse();
            } else {
                expandableLayout_3.expand();
            }
        }


    }




}