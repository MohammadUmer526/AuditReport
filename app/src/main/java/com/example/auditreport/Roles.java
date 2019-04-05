package com.example.auditreport;

import java.util.ArrayList;

public class Roles {

    private String roleName;
    //private boolean mOnline;

    public Roles(String roleName) {
        roleName = roleName;
       // mOnline = online;
    }

    public String getRoleName() {
        return roleName;
    }



    private static int lastContactId = 0;

    public static ArrayList<Roles> createContactsList(int numContacts) {
        ArrayList<Roles> roles = new ArrayList<Roles>();

        for (int i = 1; i <= numContacts; i++) {
            roles.add(new Roles("" + ++lastContactId));
        }

        return roles;
    }
}
