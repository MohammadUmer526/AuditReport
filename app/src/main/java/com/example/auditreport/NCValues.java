package com.example.auditreport;

import android.content.res.Resources;
import android.text.Layout;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class NCValues {


    private TextView  txtNc1, txt_Nc_Summary, txt_Type_1, txt_Owner_1, txt_Total_Points;
    private EditText edt_nc_summary,edt_Type_1, edt_Owner_1;
    private Spinner spinner_1;


    private NCValues(TextView txtNc1, TextView txt_Nc_Summary, TextView txt_Type_1,
                     TextView txt_Owner_1, TextView txt_Total_Points, EditText edt_nc_summary,
                     EditText edt_Type_1, EditText edt_Owner_1, Spinner spinner_1){


        this.txtNc1 = txtNc1;
        this.txt_Nc_Summary = txt_Nc_Summary;
        this.txt_Type_1 = txt_Type_1;
        this.txt_Owner_1 = txt_Owner_1;
        this.txt_Total_Points = txt_Total_Points;
        this.edt_nc_summary = edt_nc_summary;
        this.edt_Type_1 = edt_Type_1;
        this.edt_Owner_1 = edt_Owner_1;
        this.spinner_1 = spinner_1;

    }

    public TextView getTxtNc1() {
        return txtNc1;
    }

    public TextView getTxt_Nc_Summary1() {
        return txt_Nc_Summary;
    }

    public TextView getTxt_Type_1() {
        return txt_Type_1;
    }
    public TextView getTxt_Owner_1() {
        return txt_Owner_1;
    }
    public TextView getTxt_Total_Points() {
        return txt_Total_Points;
    }

    public EditText getEdt_nc_summary(){
        return edt_nc_summary;
    }

    public EditText getEdt_Type_1(){
        return edt_Type_1;
    }

    public EditText getEdt_Owner_1(){
        return edt_Owner_1;
    }

    public Spinner getSpinner_1(){
        return spinner_1;
    }

    static ArrayList<NCValues> createNCValueList(Layout layout) {
        ArrayList<NCValues> ncValuesList = new ArrayList<>();

        ncValuesList.add(new NCValues(layout.getText(R.id.txt_Nc1),R.id.txt_Summary,R.id.txt_Type,R.id.txt_Owner_1,
                           R.id.txt_Total_Points,R.id.edt_Summary,R.id.txt_Type,R.id.edt_Type_1,
                           R.id.edt_Owner_1,R.id.spinner_1));



    }
