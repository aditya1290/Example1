package com.example.example1;


import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {


    Context C;
    ArrayList<Model> models;

    public MyAdapter(Context C, ArrayList<Model> models){

        this.C = C;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myholder, int i) {

        myholder.mtitle.setText(models.get(i).getTitle());
        myholder.mdesc.setText(models.get(i).getDesc());
        myholder.mImageview.setImageResource(models.get(i).getImage());

        myholder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                if(position==0)
                {
                    Intent i = new Intent(C.getApplicationContext(), LocationActivity.class);
                    C.startActivity(i);
                }
                if(position==1)
                {
                    Intent i = new Intent(C.getApplicationContext(), ScanActivity.class);
                    C.startActivity(i);
                }
                if(position==2)
                {
                    Intent i = new Intent(C.getApplicationContext(), SearchActivity.class);
                    C.startActivity(i);
                }
                if(position==3)
                {
                    Intent i = new Intent(C.getApplicationContext(), SettingsActivity.class);
                    C.startActivity(i);
                }
                if(position == 4)
                {
                    Intent i = new Intent(C.getApplicationContext(), ProfileActivity.class);
                    C.startActivity(i);
                }





            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
