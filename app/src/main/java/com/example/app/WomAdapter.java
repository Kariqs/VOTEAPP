package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WomAdapter extends RecyclerView.Adapter<WomAdapter.MyViewHolder> {
    Context context;
    ArrayList<WrepHelper> list;

    public WomAdapter(Context context, ArrayList<WrepHelper> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.wresults,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        WrepHelper wrepHelper= list.get(position);
        holder.Womenrep.setText(wrepHelper.getWomen_rep());
        holder.Votes.setText(wrepHelper.getW_votes());
        holder.Constituency.setText(wrepHelper.getW_constituency());
        holder.Ward.setText(wrepHelper.getW_ward());
        holder.Polling_Station.setText(wrepHelper.getW_ps());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Womenrep,Votes,Constituency,Ward,Polling_Station;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Womenrep = itemView.findViewById(R.id.textWrep);
            Votes = itemView.findViewById(R.id.textVotes);
            Constituency = itemView.findViewById(R.id.textConstituency);
            Ward= itemView.findViewById(R.id.textWard);
            Polling_Station = itemView.findViewById(R.id.textPs);
        }
    }
}
