package com.example.hp.germanarticles;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hp on 16-07-2019.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {


    private ArrayList<DataModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewGerman;
        TextView textViewEnglish;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewGerman = (TextView) itemView.findViewById(R.id.textViewGerman);
            this.textViewEnglish = (TextView) itemView.findViewById(R.id.textViewEnglish);
        }


    }

    public CustomAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewGerman;
        TextView textViewVersion = holder.textViewEnglish;


        textViewName.setText(dataSet.get(listPosition).getGermanName());
        textViewVersion.setText(dataSet.get(listPosition).getEnglishName());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
