package com.example.geyik.termproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.welyre.R;

import org.json.JSONArray;
import org.json.JSONException;

public class AdapterArtist extends AdapterProj {
    String[] artist_name= {"Rihanna", "Ariana Grande", "Beyonce", "Nicki Minaj",
            "Justin Bieber", "Chris Brown", "Mariha Carey",
            "Drake", "Katy Perry", "Selena Gomez", "Taylor Swift"};

    public AdapterArtist(String query, SearchBehaviour parent) throws JSONException {
        super(query, parent);
        //super.dataArray = get data from API(query);

        dataArray = new JSONArray(artist_name);
    }

    @NonNull
    @Override
    public DataArtist onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.recycler_artist;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = true;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        return new DataArtist(view, this.parent);
    }
}
