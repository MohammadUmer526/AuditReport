package com.example.auditreport;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    private Context context;
    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String NAME = "NAME";
    public static final String EMAIl = "EMAIL";
    public static final String ID = "ID";
    public static final String mNoNc = "mNoNc";

    public SessionManager(Context context){
        this.context = context;
        int PRIVATE_MODE = 0;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();

    }

    public void createSession(String name, String email, String id){
        editor.putBoolean(LOGIN, true);
        editor.putString(NAME, name);
        editor.putString(EMAIl,email);
        editor.putString(ID, id);
        editor.apply();
    }

    public void createSession2(String mnonc){
        editor.putString(mNoNc, mnonc);
        editor.apply();
    }

    private boolean isLoggin(){
        return sharedPreferences.getBoolean(LOGIN,false);
    }
    public void checkLogin(){
        if(!this.isLoggin()){
            Intent ab = new Intent(context, MainActivity.class);
            context.startActivity(ab);
            ((MainActivity) context).finish();
        }
    }

    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new HashMap<>();
        user.put(NAME, sharedPreferences.getString(NAME, null));
        user.put(EMAIl,sharedPreferences.getString(EMAIl,null));
        user.put(ID,sharedPreferences.getString(ID,null));
        return  user;

    }

    public HashMap<String, String> getmNoNc(){
        HashMap<String, String> mnonc = new HashMap<>();
        mnonc.put(mNoNc, sharedPreferences.getString(mNoNc, null));
        return mnonc;
    }


    public void logout(){
        editor.clear();
        editor.commit();
        Intent lg  = new Intent(context, MainActivity.class);
        context.startActivity(lg);
        ((MainActivity)context).finish();
    }
}
