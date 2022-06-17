package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GovAdapter extends RecyclerView.Adapter<GovAdapter.MyViewHolder> {
    Context context;
    ArrayList<UserHelper> list;

    public GovAdapter(Context context, ArrayList<UserHelper> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.gresults,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UserHelper userHelper= list.get(position);
        holder.Governor.setText(userHelper.getGovernor());
        holder.Votes.setText(userHelper.getGov_votes());
        holder.Constituency.setText(userHelper.getGov_constituency());
        holder.Ward.setText(userHelper.getGov_ward());
        holder.Polling_Station.setText(userHelper.getGov_ps());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Governor,Votes,Constituency,Ward,Polling_Station;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Governor = itemView.findViewById(R.id.textGovernor);
            Votes = itemView.findViewById(R.id.textVotes);
            Constituency = itemView.findViewById(R.id.textConstituency);
            Ward= itemView.findViewById(R.id.textWard);
            Polling_Station = itemView.findViewById(R.id.textPs);
        }
    }
}
