package com.example.geyik.termproject.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.geyik.termproject.ActivitySearchResults;

import org.json.JSONObject;

public abstract class DataProj extends RecyclerView.ViewHolder {
    protected ActivitySearchResults parent;
    protected String nextType;

    public DataProj(@NonNull View itemView, final ActivitySearchResults rV) {
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