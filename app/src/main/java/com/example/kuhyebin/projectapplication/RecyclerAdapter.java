package com.example.kuhyebin.projectapplication;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Created by kuhyebin on 2016-08-14.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder>{

    Context mcontext;


    List<Item> items;
    RecyclerAdapter(List<Item> items, Context context){
        this.items = items;
        mcontext = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mtitle.setText(items.get(position).title);
        holder.mimage.setImageResource(items.get(position).image);
        holder.mdetaile.setText(items.get(position).detail);
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext,items.get(position).title ,Toast.LENGTH_SHORT).show();
            }
        });    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    }
