package com.example.auditreport;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringWriter;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import helpers.CustomJSONObjectRequest;
import helpers.VolleyController;

public class LogIn extends AppCompatActivity {


    SessionManager sessionManager;
    private EditText name, password;
    private ProgressBar loading;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // initialize awsomevalidation's object
        //defining AwesomeValidation object
        AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        // Setting variables
        loading = findViewById(R.id.loading);
        name = findViewById(R.id.u_name);
        password = findViewById(R.id.password);
        Button btn_login = findViewById(R.id.btn_login);
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
                0, word2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        link_register.append(word2);

        awesomeValidation.addValidation(this, R.id.u_name,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",
                R.string.nameerror);

        link_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lr = new Intent(LogIn.this, Registration.class);
                startActivity(lr);
            }
        });

        //instance of SessionManager
        sessionManager = new SessionManager(this);


        // click listenr for logging a user

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        String mName = name.getText().toString().trim();
        String mPass = password.getText().toString().trim();

        if(!mName.isEmpty() || !mPass.isEmpty()){
            logIn(mName, mPass);
        }else {
            name.setError("Please insert an e-mail");
            password.setError("Please insert a password");
        }
    }
     });

        }


    private void logIn(final String name, final String password) {
        RequestQueue queue = Volley.newRequestQueue(this);
        loading.setVisibility(View.VISIBLE);
       // btn_login.setVisibility(View.GONE);




        String URL_LOGIN = "http://192.168.142.25/Systems/api/UserLogin.php";

        Map<String, String> postParam= new HashMap<String, String>();
        postParam.put("username", name);
        postParam.put("password", password);



        JsonObjectRequest rq = new JsonObjectRequest(Request.Method.POST, URL_LOGIN, new JSONObject(postParam),

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            JSONObject jsonObject = new JSONObject(response.toString());
                            String success = jsonObject.getString("data");

                            Intent se = new Intent(LogIn.this, FormPageOne.class);
                            startActivity(se);
                           // int success = Integer.parseInt(response.getString("success"));
/*
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if (success.equals("1"))

                            {

                                for (int i = 0; i < jsonArray.length(); i++)
                                {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                   // String name = object.getString("username").trim();
                                   // String email = object.getString("email").trim();
                                   // String id = object.getString("id").trim();

                                    Toast.makeText(LogIn.this, "Success Login." +
                                            " \nYour Name: " + name
                                           , Toast.LENGTH_SHORT).show();
                                   // sessionManager.createSession(name);


                                    Intent se = new Intent(LogIn.this, FormPageOne.class);
                                    startActivity(se);

                                    loading.setVisibility(View.GONE);
                                }
                            }
                            */
                        } catch (JSONException e) {
                            e.printStackTrace();
                            loading.setVisibility(View.GONE);
                            //btn_login.setVisibility(View.VISIBLE);
                            Toast.makeText(LogIn.this, "Error"+ e.toString(),
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        loading.setVisibility(View.GONE);
                        //btn_login.setVisibility(View.VISIBLE);
                        Toast.makeText(LogIn.this, "Error"+ error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        ){

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                //headers.put("username",name);
                //headers.put("password", password);
                return headers;
            }

    };

    queue.add(rq);

    }



    }

