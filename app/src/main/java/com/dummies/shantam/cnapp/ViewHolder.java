package com.dummies.shantam.cnapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by hp on 08-04-2019.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;
    public ViewHolder(View itemView) {
        super(itemView);
        mView=itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view,getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view,getAdapterPosition());
                return true;
            }
        });
    }
    public void setDetails(Context ctx, String title, String image, String description, String address)
    {
        TextView mTitleView =mView.findViewById(R.id.rTitletv);
        TextView mdescriptionView=mView.findViewById(R.id.rdescrptiontv);
        TextView maddressView=mView.findViewById(R.id.raddress);
        ImageView mimageView=mView.findViewById(R.id.rImageViewtv);

        //
        mTitleView.setText(title);
        mdescriptionView.setText(description);
        maddressView.setText(address);
        Picasso.get().load(image).into(mimageView);
    }

    private ViewHolder.ClickListener mClickListener;

    public interface ClickListener
    {
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener)
    {
        mClickListener = clickListener;
    }
}