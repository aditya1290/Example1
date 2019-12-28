package com.example.example1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView mImageview;
    TextView mtitle, mdesc;
    ItemClickListener itemClickListener;

    MyHolder(@NonNull View itemView) {
        super(itemView);

        this.mImageview = itemView.findViewById(R.id.ImageIv);
        this.mtitle = itemView.findViewById(R.id.titleIv);
        this.mdesc = itemView.findViewById(R.id.DescriptionIv);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClickListener(v, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }
}