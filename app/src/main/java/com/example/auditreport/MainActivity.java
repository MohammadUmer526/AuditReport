package com.example.auditreport;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

import helpers.CustomJSONObjectRequest;
import helpers.VolleyController;

public class MainActivity extends AppCompatActivity {


    // declare the variables
    SessionManager sessionManager;
    private EditText name, password;
    private ProgressBar loading;

    private String url = "http://192.168.142.25/Systems/api/login.php";

    private static String KEY_SUCCESS = "success";
    private static String KEY_USERID  = "login";
    private static String KEY_EMAILID  = "email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
                 Intent lr = new Intent(MainActivity.this, Registration.class);
                 startActivity(lr);
             }
         });

        //instance of SessionManager
        sessionManager = new SessionManager(this);

        // when click on log in check the credentials
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (TextUtils.isEmpty(name.getText())) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid user name", Toast.LENGTH_LONG).show();
                }else if(TextUtils.isEmpty(password.getText()) || password.getText().length() < 3 || password.getText().length() > 32) {
                    Toast.makeText(getApplicationContext(), "Your password must contain 8-32 character.", Toast.LENGTH_LONG).show();
                }
                else{
                    CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST, url, null,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {

                                        JSONObject jsonObject = new JSONObject(response.toString());
                                        //String success = jsonObject.getString("success");
                                        JSONArray jsonArray = jsonObject.getJSONArray("login");

                                        if (response.getString(KEY_SUCCESS) != null) {
                                            int success = Integer.parseInt(response.getString(KEY_SUCCESS));


                                            if (success == 1) {
                                                for (int i = 0; i < jsonArray.length(); i++) {

                                                    JSONObject object = jsonArray.getJSONObject(i);


                                                    String name = object.getString("name").trim();
                                                    String email = object.getString("email").trim();
                                                    String id = object.getString("id").trim();
                                                    String desg = object.getString("designation").trim();

                                                  //  Toast.makeText(MainActivity.this, "Success Login" +
                                                    //        " \nYour Name: " + name + " \nEmail: " + email + "Des: " + desg, Toast.LENGTH_SHORT).show();
                                                    //sessionManager.createSession(name, email, id);

                                                    if (desg.equals("Admin")) {
                                                        Toast.makeText(MainActivity.this, "Success Login" +
                                                                " \nYour Name: " + name + " \nEmail: " + email + "\nDes: " + desg, Toast.LENGTH_SHORT).show();
                                                        sessionManager.createSession(name, email, id);

                                                        SharedPreferences name_preference = getSharedPreferences("preference_name",
                                                                Context.MODE_PRIVATE);
                                                        name_preference.edit().putString("name", name).apply();

                                                        SharedPreferences mail_preference = getSharedPreferences("preference_email",
                                                                Context.MODE_PRIVATE);
                                                        mail_preference.edit().putString("email", email).apply();


                                                        Intent home = new Intent(MainActivity.this, AdminHome.class);
                                                        startActivity(home);
                                                        finish();
                                                    } else {

                                                        Toast.makeText(MainActivity.this, "Success Login" +
                                                                " \nYour Name: " + name + " \nEmail: " + email + "Des: " + desg, Toast.LENGTH_SHORT).show();
                                                        sessionManager.createSession(name, email, id);

                                                        SharedPreferences name_preference = getSharedPreferences("preference_name",
                                                                Context.MODE_PRIVATE);
                                                        name_preference.edit().putString("name", name).apply();

                                                        SharedPreferences mail_preference = getSharedPreferences("preference_email",
                                                                Context.MODE_PRIVATE);
                                                        mail_preference.edit().putString("email", email).apply();

                                                        Intent home = new Intent(MainActivity.this, AuditerHome.class);
                                                        startActivity(home);
                                                        finish();
                                                    }
                                                }
                                            } else if (success == 0) {
                                                Toast.makeText(getApplicationContext(), "Invalid email or password.", Toast.LENGTH_LONG).show();


                                            } else {
                                                Toast.makeText(getApplicationContext(), "Invalid email or password.", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("Response Error", error.toString());
                            Toast.makeText(getApplicationContext(), "Something went wrong. Please try again", Toast.LENGTH_LONG).show();
                        }
                    }) {

                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            HashMap<String, String> headers = new HashMap<String, String>();
                            headers.put("Content-Type", "application/x-www-form-urlencoded");
                            return headers;
                        }

                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("username", name.getText().toString());
                            params.put("password", password.getText().toString());
                            return params;
                        }

                    };

                    VolleyController.getInstance(getApplicationContext()).addToRequestQueue(rq);
                }
            }

        });

    }

}