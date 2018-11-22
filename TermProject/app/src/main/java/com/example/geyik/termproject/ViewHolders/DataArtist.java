package com.example.geyik.termproject.ViewHolders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.android.welyre.R;
import com.example.geyik.termproject.ActivitySearchResults;

import org.json.JSONObject;

public class DataArtist extends DataProj {
    TextView placeholder;

    public DataArtist(@NonNull View itemView, ActivitySearchResults rV) {
        super(itemView, rV);

        nextType = "album";
        placeholder = itemView.findViewById(R.id.placeholderArtist);
    }

    @Override
    public void bind(JSONObject obj) {
        placeholder.setText(obj.toString());
    }

    @Override
    public String getQuery() {
        return null;
    }
}
