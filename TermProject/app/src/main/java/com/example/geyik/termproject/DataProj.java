package com.example.geyik.termproject;

import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class DataProj extends RecyclerView.ViewHolder {
    protected SearchBehaviour parent;
    protected String nextType;

    public DataProj(@NonNull View itemView, final SearchBehaviour rV) {
        super(itemView);
        parent = rV;

        itemView.setOnClickListener(new View.OnClickListener() { //DataSong will override this listener
            @Override
            public void onClick(View v) {
                parent.updateAdapter(nextType, getQuery());
            }
        });
    }

    protected abstract String getQuery();

    public abstract void bind(JSONObject obj);
}