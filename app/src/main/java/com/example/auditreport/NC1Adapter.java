package com.example.auditreport;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NC1Adapter extends RecyclerView.Adapter<NC1Adapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;
        private Context context;

        ViewHolder(Context context, View itemView) {
            super(itemView);

            this.context = context;
            tvName = itemView.findViewById(R.id.tv_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                NC1 nc1 = nc1List.get(position);

                Intent intent = new Intent(context, nc1.getActivityClass());
                context.startActivity(intent);
            }
        }
    }

    private List<NC1> nc1List;
    private List<NC1> copyNC1List;
    private Context context;

    NC1Adapter(Context context, List<NC1> nc1List) {
        this.nc1List = nc1List;
        copyNC1List = new ArrayList<>(nc1List);
        this.context = context;
    }

    private Context getContext() {
        return context;
    }

    @Override
    public NC1Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        return new ViewHolder(context, inflater.inflate(R.layout.card_view, parent, false));
    }



    @Override
    public void onBindViewHolder(NC1Adapter.ViewHolder viewHolder, int position) {
        NC1 nc1 = nc1List.get(position);

        TextView textView = viewHolder.tvName;
        textView.setText(nc1.getName());
    }

    @Override
    public int getItemCount() {
        return nc1List.size();
    }

    public void filter(String text) {
        nc1List.clear();
        if (text.isEmpty()){
            nc1List.addAll(copyNC1List);
        } else{
            text = text.toLowerCase();
            for (NC1 nc1: copyNC1List){
                if (nc1.getName().toLowerCase().contains(text)) {
                    nc1List.add(nc1);
                }
            }
        }
        notifyDataSetChanged();
    }
}

