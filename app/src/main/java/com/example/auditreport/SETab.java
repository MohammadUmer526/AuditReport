package com.example.auditreport;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import net.cachapa.expandablelayout.ExpandableLayout;


public class SETab extends Fragment implements View.OnClickListener{

    private ExpandableLayout  expandableLayout_1, expandableLayout_2, expandableLayout_3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_setab, container, false);

  //     expandableLayout_0 = rootView.findViewById(R.id.expandable_layout_0);


        expandableLayout_1 = rootView.findViewById(R.id.expandable_layout_1);


/*


        expandableLayout_0.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
            @Override
            public void onExpansionUpdate(float expansionFraction, int state) {
                Log.d("ExpandableLayout0", "State: " + state);
            }
        });
      //  expandButton_1.setOnClickListener(this);
*/

        expandableLayout_1.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
            @Override
            public void onExpansionUpdate(float expansionFraction, int state) {
                Log.d("ExpandableLayout0", "State: " + state);
            }
        });



        rootView.findViewById(R.id.expand_button).setOnClickListener(this);
        //rootView.findViewById(R.id.expand_button_2).setOnClickListener(this);



        return rootView;
    }



    @Override
    public void onClick(View view) {

        if (expandableLayout_1.isExpanded()) {
            expandableLayout_1.collapse();
        }

        else  {
            expandableLayout_1.expand();
        }

    }

}
