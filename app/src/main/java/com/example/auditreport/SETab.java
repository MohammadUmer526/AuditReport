package com.example.auditreport;


import android.annotation.SuppressLint;
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
import android.widget.TextView;


import net.cachapa.expandablelayout.ExpandableLayout;



public class SETab extends Fragment implements View.OnClickListener {

    private Spinner spinner_se_pi, spinner_se_pp, spinner_se_pm;
    private TextView txt_pi_points_attain;
    private TextView txt_pp_points_attain;
    private TextView txt_pm_points_attain;
    private TextView txt_pi_total_points;


    private ExpandableLayout expandableLayout_1, expandableLayout_2, expandableLayout_3;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_setab, container, false);

        expandableLayout_1 = rootView.findViewById(R.id.expandable_layout_1);
        expandableLayout_2 = rootView.findViewById(R.id.expandable_layout_2);
        expandableLayout_3 = rootView.findViewById(R.id.expandable_layout_3);

        spinner_se_pi = rootView.findViewById(R.id.spinner_se_pi);
        spinner_se_pp = rootView.findViewById(R.id.spinner_se_pp);
        spinner_se_pm = rootView.findViewById(R.id.spinner_se_pm);

        txt_pi_points_attain = rootView.findViewById(R.id.txt_pi_points_attain);
        txt_pp_points_attain = rootView.findViewById(R.id.txt_pp_points_attain);
        txt_pm_points_attain = rootView.findViewById(R.id.txt_pm_points_attain);

        txt_pi_total_points = rootView.findViewById(R.id.txt_pi_total_points);
        TextView edt_pm_total_points = rootView.findViewById(R.id.txt_pm_total_points);
        TextView edt_pp_total_points = rootView.findViewById(R.id.txt_pp_total_points);

        spinner_se_pi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @SuppressLint("SetTextI18n")
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub

                txt_pi_points_attain = rootView.findViewById(R.id.txt_pi_points_attain);
                txt_pi_total_points = rootView.findViewById(R.id.txt_pi_total_points);

                switch (spinner_se_pi.getSelectedItem().toString()) {
                    case "Yes":
                       // edt_pi_points_attain.setText(String.valueOf(1));

                        break;
                    case "No":
                        txt_pi_points_attain.setText(String.valueOf(0));

                        break;
                    case "N/A":
                        txt_pi_points_attain.setText(String.valueOf(0));
                        txt_pi_total_points.setText(String.valueOf(0));
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        spinner_se_pp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txt_pp_points_attain = rootView.findViewById(R.id.txt_pp_points_attain);

                switch (spinner_se_pp.getSelectedItem().toString()){
                    case "Yes":
                       // txt_pp_points_attain.setText(String.valueOf(1));
                       // break;
                    case "No":
                        txt_pp_points_attain.setText(String.valueOf(0));
                        break;
                    case "N/A":
                        txt_pp_points_attain.setText("0");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_se_pm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                txt_pm_points_attain = rootView.findViewById(R.id.txt_pm_points_attain);

                switch (spinner_se_pm.getSelectedItem().toString()) {
                    case "Yes":
                     //   txt_pm_points_attain.setText(String.valueOf(1));
                      //  break;
                    case "No":
                        txt_pm_points_attain.setText(String.valueOf(0));
                        break;
                    case "N/A":
                        txt_pm_points_attain.setText("0");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

        txt_pi_points_attain = view.findViewById(R.id.txt_pi_points_attain);
        txt_pi_total_points = view.findViewById(R.id.txt_pi_total_points);



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