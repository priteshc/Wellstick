package com2.example.imac.wellstick.adapter;

/**
 * Created by imac on 12/21/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import com2.example.imac.wellstick.Interface.Bottclick;
import com2.example.imac.wellstick.R;

/**
 * Created by pritesh on 5/24/2017.
 */

public class PjpAdapter extends RecyclerView.Adapter<PjpAdapter.PjpHolder> {

    Context mContext;
    List<String> list;


    private int lastPosition = -1;

    private Bottclick clickListener;


    public PjpAdapter(Context c, List<String> list ) {

        mContext = c;
        this.list = list;


    }

    @Override
    public PjpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pjpcard, parent, false);

        return new PjpHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PjpHolder holder, final int position) {


     /*   holder.title.setText(list.get(position).getTitle());
        holder.producer.setText(list.get(position).getProducer());
        holder.director.setText(list.get(position).getDirector());
        holder.release.setText(list.get(position).getReleaseDate());
*/

  //      setAnimation(holder.continer, position);


    }

    public void setClickListener(Bottclick itemClickListener) {
        this.clickListener = itemClickListener;
    }

    /*private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.slideleft);
            animation.setStartOffset(position*100);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
*/
    @Override
    public int getItemCount() {
        return 1;
    }


    public class PjpHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        public TextView title,director,producer,release;
        public LinearLayout continer;


        public PjpHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            director = (TextView) itemView.findViewById(R.id.address);
            producer = (TextView) itemView.findViewById(R.id.mobile);


            continer = itemView.findViewById(R.id.container);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

            if (clickListener != null) clickListener.onClick(v, getAdapterPosition());


        }
    }

}