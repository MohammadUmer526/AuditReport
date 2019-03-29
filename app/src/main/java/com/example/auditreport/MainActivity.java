package com.example.auditreport;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;



public class MainActivity extends AppCompatActivity{


    // declare the variables
    SessionManager sessionManager;
    private EditText email, password;
    private Button btn_login;
    private ProgressBar loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // initialize awsomevalidation's object
        //defining AwesomeValidation object
        AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        // Setting variables
        loading = findViewById(R.id.loading);
        email = findViewById(R.id.u_name);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        //btnlog_out = findViewById(R.id.log_out);
        TextView link_register = findViewById(R.id.link_regist);


        //instance of spannable for coloring two different in a single TextView
        // For Black color
        Spannable word = new SpannableString("Not a member? ");
        word.setSpan(new ForegroundColorSpan(Color.BLACK), 0, word.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        link_register.setText(word);

        // For Orange color
        Spannable word2 = new SpannableString("Sign Up");
        word2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.systemsorange)),
                       0 , word2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        link_register.append(word2);

        //instance of SessionManager
        sessionManager = new SessionManager(this);


       // awesomeValidation.addValidation(this, R.id.u_name,
         //                               "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",
           //                               R.string.nameerror);





        // when click on log in check the credentials
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FormPageOne.class));


                String mEmail = email.getText().toString().trim();
                String mPass = password.getText().toString().trim();

                if(!mEmail.isEmpty() || !mPass.isEmpty()){
                    logIn(mEmail,mPass);
                }else {
                    email.setError("Please insert an user name");
                    password.setError("Please insert a password");
                }

            }





        });
        // intent to register activity
        link_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Registration.class));
            }
        });

    }

        //LogIn method to perform login's functionalities
    public void logIn(final String email, final  String password){
        loading.setVisibility(View.VISIBLE);
        btn_login.setVisibility(View.GONE);

        String URL_LOGIN = "" ;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {

                    @Override

                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("Success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if (success.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String name = object.getString("name").trim();
                                    String email = object.getString("email").trim();
                                    String id = object.getString("id").trim();


                                    Toast.makeText(MainActivity.this, "Success Login" +
                                                    " \nYour Name: " + name + " \nYour Email: " + email,
                                            Toast.LENGTH_SHORT).show();
                                    sessionManager.createSession(name, email, id);

                                    loading.setVisibility(View.GONE);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            loading.setVisibility(View.GONE);
                            btn_login.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Error" + e.toString(),
                                            Toast.LENGTH_SHORT).show();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility(View.GONE);
                        btn_login.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, "Error"+ error.toString(),
                                        Toast.LENGTH_SHORT).show();
                    }


                       }
                    )

        {

            // putting the valid credentials
            @Override
            protected Map<String, String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put("email",email);
                params.put("password", password);
                return  params;
            }

                };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
                                    requestQueue.add(stringRequest);



    }

}
