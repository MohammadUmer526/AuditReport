package com.example.auditreport;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ViewRoles extends AppCompatActivity {

    ArrayList<Roles> mRoles;
    private String URL_List = "http://192.168.142.25:8080/Systems/api/roles.php";
    private static ProgressDialog mProgressDialog;
    private RolesAdapter rolesAdapter;
    private Button btn_Upload;
    private ListView listView;


    private Menu action;
    private String getID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_roles);

        listView = findViewById(R.id.lv_Roles);

//        role_Name = (EditText) findViewById(R.id.role_name);

        retriveJSon();

        //btn_Upload = findViewById(R.id.upload_button);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

             //   showInputBox(listView.ge)

            }
        });


    }

    private void retriveJSon() {

        //showSimpleProgressDialog(this, "Loading...","Fetching roles",false);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_List, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
                    JSONObject object = new JSONObject(response.toString());
                    {

                        mRoles = new ArrayList<>();
                        JSONArray jsonArray = object.getJSONArray("data");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            Roles roles = new Roles();
                            JSONObject obj = jsonArray.getJSONObject(i);
                            roles.setRoleName(obj.getString("name"));
                            roles.setId(obj.getString("id"));

                            mRoles.add(roles);
                        }

                        setUplistview();


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(),
                                Toast.LENGTH_SHORT).show();

                    }
                });

        // request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);

    }

    private void setUplistview() {
        removeSimpleProgressDialog();  //will remove progress dialog
        rolesAdapter = new RolesAdapter(this, mRoles);
        listView.setAdapter(rolesAdapter);
    }

    public static void removeSimpleProgressDialog() {
        try {
            if (mProgressDialog != null) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                    mProgressDialog = null;
                }
            }
        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();

        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void showSimpleProgressDialog(Context context, String title,
                                                String msg, boolean isCancelable) {
        try {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog.show(context, title, msg);
                mProgressDialog.setCancelable(isCancelable);
            }

            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }

        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();
        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.auditer_home, menu);

        // action = menu;
        //action.findItem(R.id.menu_save).setVisible(false);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        switch (item.getItemId()) {





            case R.id.menu_edit:
                RolesAdapter.ViewHolder viewHolder = new RolesAdapter.ViewHolder();

              viewHolder.role_Name.setFocusableInTouchMode(true);

                InputMethodManager inm = (InputMethodManager) getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                inm.showSoftInput(viewHolder.role_Name, InputMethodManager.SHOW_IMPLICIT);
                action.findItem(R.id.menu_edit).setVisible(true);
                action.findItem(R.id.menu_save).setVisible(true);

                return true;

            case R.id.menu_save:
                SaveEditDeatail();



                action.findItem(R.id.menu_edit).setVisible(true);
                action.findItem(R.id.menu_save).setVisible(true);
                viewHolder = new RolesAdapter.ViewHolder();

               viewHolder.role_Name.setFocusableInTouchMode(true);

                viewHolder.role_Name.setFocusable(false);



                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
    }

    public void SaveEditDeatail() {
        RequestQueue queue = Volley.newRequestQueue(this);

        RolesAdapter.ViewHolder viewHolder = new RolesAdapter.ViewHolder();



        final String role_Name = viewHolder.role_Name.getText().toString().trim();
        final String id = getID;

        String URL_EDIT = "http://192.168.142.25:8080/Systems/api/updateroles.php";

        Map<String, String> postParam = new HashMap<String, String>();
        postParam.put("name", role_Name);
        postParam.put("id",id);

        JsonObjectRequest rq = new JsonObjectRequest(Request.Method.POST, URL_EDIT, new JSONObject(postParam),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            JSONObject jsonObject = new JSONObject(response.toString());
                            String success = jsonObject.getString("data");

                        } catch (JSONException e) {
                            e.printStackTrace();
                            // loading.setVisibility(View.GONE);
                            //btn_login.setVisibility(View.VISIBLE);
                            //  Toast.makeText(LogIn.this, "Error"+ e.toString(),
                            //        Toast.LENGTH_SHORT).show();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        // loading.setVisibility(View.GONE);
                        //btn_login.setVisibility(View.VISIBLE);
                        // Toast.makeText(LogIn.this, "Error"+ error.toString(),
                        //    Toast.LENGTH_SHORT).show();
                    }
                }
        ) {

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