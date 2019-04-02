package com.example.auditreport;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.riddhimanadib.formmaster.FormBuilder;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementPickerDate;
import me.riddhimanadib.formmaster.model.FormElementPickerTime;
import me.riddhimanadib.formmaster.model.FormElementTextEmail;
import me.riddhimanadib.formmaster.model.FormElementTextMultiLine;
import me.riddhimanadib.formmaster.model.FormElementTextNumber;
import me.riddhimanadib.formmaster.model.FormElementTextPassword;
import me.riddhimanadib.formmaster.model.FormElementTextPhone;
import me.riddhimanadib.formmaster.model.FormElementTextSingleLine;
import me.riddhimanadib.formmaster.model.FormHeader;

public class NC extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private FormBuilder mFormBuilder;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nc);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        List<NC1> nc1List = NC1.createNC1List(getResources());
        final NC1Adapter adapter = new NC1Adapter(this, nc1List);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


/*
        sessionManager = new SessionManager(getApplicationContext());
        HashMap<String, String> mnonc = sessionManager.getmNoNc();
        String mNoNc = mnonc.get(SessionManager.mNoNc);

        Toast.makeText(this, mNoNc+"", Toast.LENGTH_LONG).show();

*/


       // setupToolBar();
      //  setupForm();
    }
/*
    private void setupToolBar() {

        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }
        private void setupForm() {

              //  mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                mFormBuilder = new FormBuilder(this, mRecyclerView);




            FormHeader nc_header1 = FormHeader.createInstance("NC#1");
            FormElementTextEmail element11 = FormElementTextEmail.createInstance().setTitle("Non Conformance Summar# 1").setHint("");
            FormElementTextPhone element12 = FormElementTextPhone.createInstance().setTitle("Type# 1").setValue("");
            FormElementTextPassword element13 = FormElementTextPassword.createInstance().setTitle("Owner 1").setValue("");



            FormHeader nc_header2 = FormHeader.createInstance("NC#2");
            FormElementTextSingleLine element21 = FormElementTextSingleLine.createInstance().setTitle("Non Conformance Summar# 2");
            FormElementTextMultiLine element22 = FormElementTextMultiLine.createInstance().setTitle("Type# 2");
            FormElementTextNumber element23 = FormElementTextNumber.createInstance().setTitle("Owner 2").setValue("");

            FormHeader nc_header3 = FormHeader.createInstance("NC#3");
            FormElementPickerDate element31 = FormElementPickerDate.createInstance().setTitle("Non Conformance Summar# 3").setDateFormat("");
            FormElementPickerTime element32 = FormElementPickerTime.createInstance().setTitle("Type# 3").setTimeFormat("");
            FormElementTextPassword element33 = FormElementTextPassword.createInstance().setTitle("Owner 3").setValue("");

            FormHeader nc_header4 = FormHeader.createInstance("NC#4");
            FormElementTextSingleLine element41 = FormElementTextSingleLine.createInstance().setTitle("Non Conformance Summar# 4");
            FormElementTextMultiLine element42 = FormElementTextMultiLine.createInstance().setTitle("Type# 4");
            FormElementTextNumber element43 = FormElementTextNumber.createInstance().setTitle("Owner 4").setValue("");

            FormHeader nc_header5 = FormHeader.createInstance("NC#5");
            FormElementTextSingleLine element51 = FormElementTextSingleLine.createInstance().setTitle("Non Conformance Summar# 5");
            FormElementTextMultiLine element52 = FormElementTextMultiLine.createInstance().setTitle("Type# 5");
            FormElementTextNumber element53 = FormElementTextNumber.createInstance().setTitle("Owner 5").setValue("");

            FormHeader nc_header6 = FormHeader.createInstance("NC#6");
            FormElementTextSingleLine element61 = FormElementTextSingleLine.createInstance().setTitle("Non Conformance Summar# 6");
            FormElementTextMultiLine element62 = FormElementTextMultiLine.createInstance().setTitle("Type# 6");
            FormElementTextNumber element63 = FormElementTextNumber.createInstance().setTitle("Owner 6").setValue("");


            List<BaseFormElement> formItems = new ArrayList<>();
            formItems.add(nc_header1);
            formItems.add(element11);
            formItems.add(element12);
            formItems.add(element13);
            formItems.add(nc_header2);
            formItems.add(element21);
            formItems.add(element22);
            formItems.add(element23);
            formItems.add(nc_header3);
            formItems.add(element31);
            formItems.add(element32);
            formItems.add(element33);
            formItems.add(nc_header4);
            formItems.add(element41);
            formItems.add(element42);
            formItems.add(element43);
            formItems.add(nc_header5);
            formItems.add(element51);
            formItems.add(element52);
            formItems.add(element53);
            formItems.add(nc_header6);
            formItems.add(element61);
            formItems.add(element62);
            formItems.add(element63);

            for (int i =0; i < 3; i++){
                mFormBuilder.addFormElements(formItems);
            }

*/




    }
