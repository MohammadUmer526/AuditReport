package com.example.auditreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class NCBaseAdapter extends BaseAdapter {

    private static ArrayList<NCList> ncList;
    private LayoutInflater inflater;

    public NCBaseAdapter(Context context, ArrayList<NCList> listItems){
        ncList = listItems;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return ncList.size();
    }

    @Override
    public Object getItem(int position) {
        return ncList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null){
            convertView = inflater.inflate(R.layout.list_nc, null);
            holder = new ViewHolder();
            holder.txtSumm = (TextView) convertView.findViewById(R.id.txt_Summary);
            holder.txtType = (TextView) convertView.findViewById(R.id.txtType);
            holder.txtOwner = (TextView) convertView.findViewById(R.id.txt_Owner);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtSumm.setText(ncList.get(position).getNc_summ());
        holder.txtType.setText(ncList.get(position).getType());
        holder.txtOwner.setText(ncList.get(position).getOwner());


        return convertView;
    }


    static class ViewHolder {
        TextView txtSumm;
        TextView txtType;
        TextView txtOwner;
    }
}
