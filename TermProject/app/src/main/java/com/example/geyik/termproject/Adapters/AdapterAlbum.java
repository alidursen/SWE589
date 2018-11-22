package com.example.geyik.termproject.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.welyre.R;
import com.example.geyik.termproject.ViewHolders.DataAlbum;
import com.example.geyik.termproject.ActivitySearchResults;

import org.json.JSONArray;
import org.json.JSONException;

public class AdapterAlbum extends AdapterProj {
    String[] album_name= {"Music of the Sun","A Girl like Me", "Good Girl Gone Bad",
            "Rated R", "Loud", "Talk That Talk", "Unapologetic", "Anti"};

    public AdapterAlbum(String query, ActivitySearchResults parent) throws JSONException {
        super(query, parent);
        //super.dataArray = get data from API(query);

        dataArray = new JSONArray(album_name);
    }

    @NonNull
    @Override
    public DataAlbum onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.vh_album;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = true;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        return new DataAlbum(view, this.parent);
        }
}
