package com.example.auditreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RolesAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<Roles> mRoles;

    public RolesAdapter(Context context, ArrayList<Roles> mRoles){
        this.context = context;
        this.mRoles = mRoles;
    }

    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return mRoles.size();
    }

    @Override
    public Object getItem(int position) {
        return mRoles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
             ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_roles, null, true);


            holder.role_Name = (TextView) convertView.findViewById(R.id.role_name);
            holder.id = (TextView) convertView.findViewById(R.id.edt_srn);


            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (RolesAdapter.ViewHolder)convertView.getTag();
        }


        holder.role_Name.setText(mRoles.get(position).getRoleName());
        holder.id.setText(mRoles.get(position).getId());


        return convertView;
    }



    public static class ViewHolder {


        TextView role_Name;
        TextView id;


    }
}
