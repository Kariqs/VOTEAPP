package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SenAdapter extends RecyclerView.Adapter<SenAdapter.MyViewHolder> {
    Context context;
    ArrayList<SenatorHelper> list;

    public SenAdapter(Context context, ArrayList<SenatorHelper> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.sresults,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SenatorHelper senatorHelper= list.get(position);
        holder.Senator.setText(senatorHelper.getSenator());
        holder.Votes.setText(senatorHelper.getSen_votes());
        holder.Constituency.setText(senatorHelper.getSen_constituency());
        holder.Ward.setText(senatorHelper.getSen_ward());
        holder.Polling_Station.setText(senatorHelper.getSen_ps());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Senator,Votes,Constituency,Ward,Polling_Station;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Senator = itemView.findViewById(R.id.textSenator);
            Votes = itemView.findViewById(R.id.textVotes);
            Constituency = itemView.findViewById(R.id.textConstituency);
            Ward= itemView.findViewById(R.id.textWard);
            Polling_Station = itemView.findViewById(R.id.textPs);
        }
    }
}

