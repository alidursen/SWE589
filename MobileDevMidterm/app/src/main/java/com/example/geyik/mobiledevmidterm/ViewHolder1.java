package com.example.geyik.mobiledevmidterm;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolder1 extends RecyclerView.ViewHolder {
    public TextView tv_in_vh;


    public ViewHolder1(@NonNull View itemView) {
        super(itemView);
        tv_in_vh = itemView.findViewById(R.id.tv_list_item);
    }

    public void bind(String s){
        tv_in_vh.setText(s);
    }
}
