package com.example.auditreport;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.auditreport.SessionManager.mNoNc;


@SuppressWarnings("ALL")
public class FormPageOne extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String values [] = {"CRM","Digital Framework"};
    private TextView txt_Next;
     private EditText projectName, customer, no_of_nc;
    private Spinner comp_spinner, track_spinner,  location;
    private SessionManager sessionManager;
    private String TEXT_VIEW_KEY = "com.example.auditreport.FormPageOne";

    //defining AwesomeValidation object
    private AwesomeValidation awesomeValidation, awesomeValidation1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formpageone);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        projectName = findViewById(R.id.project_name_edit);
        customer = findViewById(R.id.customer_edit);

        location = findViewById(R.id.spinner_loc);
        no_of_nc = findViewById(R.id.number_of_nc_edit);


        comp_spinner = findViewById(R.id.compet_spinner);
         track_spinner = findViewById(R.id.track_spinner);
        txt_Next = findViewById(R.id.txt_Nxt);
         comp_spinner.setOnItemSelectedListener(this);

        awesomeValidation.addValidation(this, R.id.project_name_edit,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",
                R.string.nameerror);

        txt_Next.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(FormPageOne.this, FormPageTwo.class));

                 String mProjectName = projectName.getText().toString().trim();
                 String mCustomer = customer.getText().toString().trim();
                 String mNoNc = no_of_nc.getText().toString().trim();
                 String mCompt = comp_spinner.getSelectedItem().toString();
                 String mTrack = track_spinner.getSelectedItem().toString();
                 String mLOc = location.getSelectedItem().toString();

                 if (mNoNc.isEmpty()){

                 }
                 SharedPreferences preferences = getSharedPreferences("preference_name",
                         Context.MODE_PRIVATE);
                 preferences.edit().putString("no_of_nc", mNoNc).commit();



                 if(!mProjectName.isEmpty() || !mCustomer.isEmpty() || !mNoNc.isEmpty()){
                     step1(mProjectName, mCustomer, mCompt, mTrack, mLOc);

                 } else if(mProjectName.isEmpty()){
                     projectName.setError("Enter a project name");
                 }
                 else if(mCustomer.isEmpty()){
                     customer.setError("Enter a customer");
                 }
//                 else if(mNoNc.isEmpty()){
  //                   no_of_nc.setError("Enter NC");
                // }
             }
         });



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
                List<String> list = new ArrayList<>();

                list.add("AI");
                list.add("UI");
                list.add("DS");

                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dataAdapter.notifyDataSetChanged();
                track_spinner.setAdapter(dataAdapter);
            }

            if (cs.contentEquals("Digital Framework")) {
                List<String> list = new ArrayList<>();

                list.add("Web");
                list.add("BPO");
                list.add("ERP");

                ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item, list);
                dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dataAdapter2.notifyDataSetChanged();
                track_spinner.setAdapter(dataAdapter2);
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

        public void step1(final String projectName, final  String customerName, final String mLoc,
                          final String mTrack, final String mCompt) {

            RequestQueue queue = Volley.newRequestQueue(this);

            Map<String, String> postParam= new HashMap<String, String>();
            postParam.put("projectName", projectName);
            postParam.put("Customer", customerName);
            postParam.put("location",mLoc);

            postParam.put("tracks", mTrack);
            postParam.put("competency",mCompt);

            String URL_STEP1 = "";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_STEP1,
                    new Response.Listener<String>() {

                        @Override

                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String success = jsonObject.getString("data");
                              //  JSONArray jsonArray = jsonObject.getJSONArray("login");
/*
                                if (success.equals("1")) {
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject object = jsonArray.getJSONObject(i);
                                        String projectName = object.getString("projectName")
                                                              .trim();
                                        String customerName = object.getString("customerName")
                                                              .trim();
                                        String no_of_nc = object.getString("no_of_nc");
                                        sessionManager.createSession2(mNoNc);
                                        String id = object.getString("id").trim();


                                    }
                                }
                                */
                            } catch (JSONException e) {
                                e.printStackTrace();

                                Toast.makeText(FormPageOne.this, "Error" + e.toString(),
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(FormPageOne.this, "Error" + error.toString(),
                                    Toast.LENGTH_SHORT).show();
                        }


                    }
            )
            {

             /*
                // putting the valid credentials
                @Override
                protected Map<String, String> getParams(){
                    Map<String,String> params = new HashMap<>();
                    params.put("projectName",projectName);
                    params.put("customerName", customerName);

                    return  params;
                }
*/

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    //headers.put("username",name);
                    //headers.put("password", password);
                    return headers;
                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);




    }




}