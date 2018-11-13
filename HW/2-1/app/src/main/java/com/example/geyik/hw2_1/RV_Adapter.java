package com.example.geyik.hw2_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RV_Adapter extends RecyclerView.Adapter<VH> {

    private int item_count;
    private String[] tops;
    private String[] bots;
    private Bitmap[] imgs;

    private LayoutInflater inf;

    public RV_Adapter(int count, String[] t, String[] b, Bitmap[] i, Context context){
        item_count = count;
        tops=t;
        bots=b;
        imgs=i;

        inf = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() { return item_count; }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //inf = LayoutInflater.from(parent.getContext());
        View v = inf.inflate(R.layout.rv_layout, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int pos) {
        vh.bindBotTxt(bots[pos]);
        vh.bindTopTxt(tops[pos]);
        vh.bindImg(imgs[pos]);
    }
}
