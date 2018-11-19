package com.example.geyik.termproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;

public abstract class AdapterProj extends RecyclerView.Adapter<DataProj> {
    protected JSONArray dataArray;
    protected SearchBehaviour parent;

    public AdapterProj(String query, SearchBehaviour parent) {
        this.parent = parent;
    }

    public void setParent(SearchBehaviour parent) {
        this.parent = parent;
    }


    @Override
    public void onBindViewHolder(@NonNull DataProj dataProj, int i) {
        try {
            dataProj.bind(dataArray.getJSONObject(i));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return dataArray.length();
    }


    @NonNull
    @Override
    public abstract DataProj onCreateViewHolder(ViewGroup parent, int viewType);
}
