package com.example.auditreport;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import net.cachapa.expandablelayout.ExpandableLayout;


public class SETab extends Fragment implements View.OnClickListener {


    private ExpandableLayout expandableLayout_1, expandableLayout_2, expandableLayout_3;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_setab, container, false);

        expandableLayout_1 = rootView.findViewById(R.id.expandable_layout_1);
        expandableLayout_2 = rootView.findViewById(R.id.expandable_layout_2);
        expandableLayout_3 = rootView.findViewById(R.id.expandable_layout_3);




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