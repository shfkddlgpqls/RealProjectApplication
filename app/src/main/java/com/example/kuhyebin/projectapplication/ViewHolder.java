package com.example.kuhyebin.projectapplication;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tacademy on 2016-08-16.
 */
public class ViewHolder extends RecyclerView.ViewHolder  {
    Context context;
    ImageView mimage;
    TextView mtitle;
    TextView mdetaile;
    CardView cardview;

    public ViewHolder(final View itemView) {
        super(itemView);
        mimage = (ImageView) itemView.findViewById(R.id.imageView);
        mtitle = (TextView) itemView.findViewById(R.id.text_title);
        mdetaile = (TextView) itemView.findViewById(R.id.text_detail);
        cardview = (CardView) itemView.findViewById(R.id.cardview);

    }

}



      //  itemView.setOnClickListener(new View.OnClickListener() {
      //      @Override
      //      public void onClick(View v) {
      //          int postion = getAdapterPosition();
      //          Snackbar.make(v, "Clci"+postion,Snackbar.LENGTH_LONG)
      //                  .setAction("Action",null).show();
      //      }
      //  });
   // }
//}
