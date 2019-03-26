package com.example.auditreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FormPageOne extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String values [] = {"CRM","Digital Framework"};
    private TextView txt_Next;
     private EditText projectName, customer, location, no_of_nc;
    private Spinner comp_spinner, track_spinner;
    private String TEXT_VIEW_KEY = "com.example.auditreport.FormPageOne";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formpageone);

        if(savedInstanceState != null){
             EditText projectName;
            projectName = (EditText) findViewById(R.id.project_name_edit);
            projectName.setText(savedInstanceState.getString("PM"));
        }


        /**
         * setting variables
         */
       projectName = (EditText) findViewById(R.id.project_name_edit);
        customer = findViewById(R.id.customer_edit);
        //  location = findViewById(R.id.location_edit);
        txt_Next = findViewById(R.id.txt_Nxt);
        no_of_nc = findViewById(R.id.number_of_nc_edit);

        /**
         *
         * Spinners declaration
         */


         comp_spinner = (Spinner) findViewById(R.id.compet_spinner);
         track_spinner = (Spinner) findViewById(R.id.track_spinner);
         comp_spinner.setOnItemSelectedListener(this);

         txt_Next.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(FormPageOne.this, FormPageTwo.class));
             }
         });


    }

        @Override
       public void onSaveInstanceState(Bundle savedInstanceState) {


            projectName = (EditText) findViewById(R.id.project_name_edit);
            String pm_Name = projectName.getText().toString();
            savedInstanceState.putString("PM",pm_Name);
            super.onSaveInstanceState(savedInstanceState);

        }

    /**
     * For spinners: To set another's element by element of first spinner
     * @param parent
     * @param view
     * @param position
     * @param id
     */
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            String cs = String.valueOf(comp_spinner.getSelectedItem());

            if (cs.contentEquals("CRM")) {
                List<String> list = new ArrayList<String>();

                list.add("AI");
                list.add("UI");
                list.add("DS");

                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dataAdapter.notifyDataSetChanged();
                track_spinner.setAdapter(dataAdapter);
            }

            if (cs.contentEquals("Digital Framework")) {
                List<String> list = new ArrayList<String>();

                list.add("Web");
                list.add("BPO");
                list.add("ERP");

                ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, list);
                dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dataAdapter2.notifyDataSetChanged();
                track_spinner.setAdapter(dataAdapter2);
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }




}
