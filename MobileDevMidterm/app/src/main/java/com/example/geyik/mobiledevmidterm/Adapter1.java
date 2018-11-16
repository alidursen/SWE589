package com.example.geyik.mobiledevmidterm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Adapter1 extends RecyclerView.Adapter<ViewHolder1> {
    String[] values;
    int valueCount;

    public Adapter1(String[] values, int valueCount) {
        this.values = values;
        this.valueCount = valueCount;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder, int i) {
        viewHolder.bind(values[i]);
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context                         = parent.getContext();
        int            layoutIdForListItem             = R.layout.recycler_list_item;
        LayoutInflater inflater                        = LayoutInflater.from(context);
        boolean        shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        ViewHolder1 viewHolder = new ViewHolder1(view);

        return viewHolder;
    }

    public void setData(String[] strings){
        values = strings;
        valueCount = strings.length;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return valueCount;
    }
}
