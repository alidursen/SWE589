package com.example.geyik.termproject.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.welyre.R;
import com.example.geyik.termproject.ViewHolders.DataSong;
import com.example.geyik.termproject.ActivitySearchResults;

import org.json.JSONArray;
import org.json.JSONException;

public class AdapterSong extends AdapterProj {
    String[] song_title= {"Pon de Replay", "Here I Go Again", "If It's Lovin' that You Want",
            "You Don't Love Me (No, No, No)", "That La, La, La", "The Last Time",
            "Willing to Wait", "Music of the Sun", "Let Me", "Rush",
            "There's a Thug in My Life", "Now I Know", "Pon de Replay (Remix)"};

    public AdapterSong(String query, ActivitySearchResults parent) throws JSONException {
        super(query, parent);
        //super.dataArray = get data from API(query);

        dataArray = new JSONArray(song_title);
    }

    @NonNull
    @Override
    public DataSong onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.vh_song;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = true;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        return new DataSong(view, this.parent);
    }
}
