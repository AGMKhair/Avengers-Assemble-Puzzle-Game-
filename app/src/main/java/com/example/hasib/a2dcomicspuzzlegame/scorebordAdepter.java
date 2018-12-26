package com.example.hasib.a2dcomicspuzzlegame;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by HASIB on 5/16/2018.
 */

public class scorebordAdepter extends RecyclerView.Adapter<scorebordAdepter.MyViewHolder> {


    private List<com.example.securesoftbd.avengersassemble.model> scoreList;


    public scorebordAdepter(List<model> scoreList) {
        this.scoreList = scoreList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView Image;
         public   TextView     Model, Score;
        public MyViewHolder(View itemView) {

            super(itemView);
            Image=(ImageView)itemView.findViewById(com.example.hasib.avengersassemble.R.id.image);
            Model=(TextView)itemView.findViewById(com.example.hasib.avengersassemble.R.id.mode);
            Score=(TextView)itemView.findViewById(com.example.hasib.avengersassemble.R.id.time);

        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(com.example.hasib.avengersassemble.R.layout.scoredata,parent,false);
        return new MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        model m=scoreList.get(position);
        holder.Image.setImageResource(m.getImage());
        holder.Model.setText(m.getMode());
        holder.Score.setText(m.getTime());


        String time=m.getTime();


    }


    @Override
    public int getItemCount() {
        return scoreList.size();
    }


}
