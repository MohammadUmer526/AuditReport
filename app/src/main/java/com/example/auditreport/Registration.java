package com.example.auditreport;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import org.json.JSONException;
import org.json.JSONObject;


import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {


    //declare the variables
    private EditText f_name, l_name, designation, e_mai, password, c_password;
    private Button btn_register;
    private ProgressBar loading;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //initialize the instance of awsome validation
        // define the awsome validations tep
        AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //setting the variables
        f_name = findViewById(R.id.f_name);
        l_name = findViewById(R.id.l_name);
        designation = findViewById(R.id.designation);
        e_mai = findViewById(R.id.email);
        password = findViewById(R.id.password);
        c_password = findViewById(R.id.c_password);
        btn_register = findViewById(R.id.btn_register);
        loading = findViewById(R.id.loading);



        TextView link_login = findViewById(R.id.link_login);


        //instance of spannable for coloring two different in a single TextView
        // For Black color
        Spannable word = new SpannableString("Already have an account? ");
        word.setSpan(new ForegroundColorSpan(Color.BLACK), 0, word.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        link_login.setText(word);

        // For Orange color
        Spannable word2 = new SpannableString("Sign In");
        word2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.systemsorange)),
                0 , word2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        link_login.append(word2);


        //instance if SessionManager
        sessionManager = new SessionManager(this);


        //validation for user inputs
        awesomeValidation.addValidation(this,R.id.f_name,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",
                R.string.nameerror);
        awesomeValidation.addValidation(this,R.id.l_name,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",
                R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.designation,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",
                R.string.designationerror);
        awesomeValidation.addValidation(this,R.id.email, Patterns.EMAIL_ADDRESS,
                R.string.emailerror);

        // onclick for submitting registration
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });



        // intent to log in
        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, MainActivity.class));
            }
        });
    }


    public void set(String abcm, Integer a){

    }
    /**
     *
     */
    public void Register(){
        loading.setVisibility(View.VISIBLE);
        btn_register.setVisibility(View.GONE);

        //fields for iregistration form
        final String f_name = this.f_name.getText().toString().trim();
        final String l_name = this.l_name.getText().toString().trim();
        final String email = this.e_mai.getText().toString().trim();
        final String designation = this.designation.getText().toString().trim();
        final String password = this.password.getText().toString().trim();
        final  String c_pasword = this.c_password.getText().toString().trim();


        String URL_REGIST = "" ;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if (success.equals("1")) {
                                Toast.makeText(Registration.this, "Registration " +
                                        "Successful!", Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();

                            Toast.makeText(Registration.this, "Registration Error" +
                                    e.toString(), Toast.LENGTH_SHORT).show();
                            loading.setVisibility(View.GONE);
                            btn_register.setVisibility(View.VISIBLE);

                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Registration.this, "Registration Error"
                                + error.toString(), Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        btn_register.setVisibility(View.VISIBLE);
                    }
                }
        )
        {
            // returning user inputs to DB by key value pair
            @Override
            protected Map<String, String> getParams(){

                Map<String, String> params = new HashMap<>();
                params.put("f_name",f_name);
                params.put("l_name", l_name);
                params.put("email", email);
                params.put("designation", designation);
                params.put("password", password);
                params.put("c_password", c_pasword);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}