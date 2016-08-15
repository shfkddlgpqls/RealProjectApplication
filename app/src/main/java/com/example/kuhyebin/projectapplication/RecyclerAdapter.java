package com.example.kuhyebin.projectapplication;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by kuhyebin on 2016-08-14.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private String[] titles = {"외형복원 수리 사례",
    "정비 수리 사례",
    "블랙박스,내비,광택,썬팅 수리 사례",
    "타이어구매 수리 사례",
    "보험 가입 사례"};

    private String[] details = {"견적이요를 통해 진행된 외형복원 리얼 수기 후기!",
    "견적이요를 통해 진행된 리얼 정비 후기!",
    "견적이요를 통해 진행된 블랙박스 내비 광택 썬팅 후기",
    "견적이요를 통해 진행된 타이어 구매 후기!",
    "견적이요을 통해 진행된 보험 가입 후기!"};

    private int[] images = {R.drawable.arrow,
    R.drawable.arrow,
    R.drawable.arrow,
    R.drawable.arrow,
    R.drawable.arrow};

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        TextView detaile;
        CardView cardview;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.imageView);
            title = (TextView)itemView.findViewById(R.id.text_title);
            detaile = (TextView)itemView.findViewById(R.id.text_detail);
            cardview = (CardView)itemView.findViewById(R.id.cardview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int postion = getAdapterPosition();
                    Snackbar.make(v, "Clci"+postion,Snackbar.LENGTH_LONG)
                            .setAction("Action",null).show();
                }
            });
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(titles[position]);
        holder.image.setImageResource(images[position]);
        holder.detaile.setText(details[position]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }


    }
