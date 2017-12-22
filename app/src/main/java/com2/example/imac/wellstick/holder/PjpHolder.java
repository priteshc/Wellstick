package com2.example.imac.wellstick.holder;

/**
 * Created by imac on 12/21/17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com2.example.imac.wellstick.R;


/**
 * Created by pritesh on 5/24/2017.
 */

public class PjpHolder extends RecyclerView.ViewHolder  {

    public TextView title,director,producer,release;
    public  LinearLayout continer;


    public PjpHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.title);
        director = (TextView) itemView.findViewById(R.id.address);
        producer = (TextView) itemView.findViewById(R.id.mobile);


        continer = itemView.findViewById(R.id.container);





    }
}