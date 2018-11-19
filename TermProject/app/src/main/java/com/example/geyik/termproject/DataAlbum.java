package com.example.geyik.termproject;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.android.welyre.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataAlbum extends DataProj {
    TextView placeholder;

    public DataAlbum(@NonNull View itemView, SearchBehaviour rV) {
        super(itemView, rV);
        nextType = "song";

        placeholder = itemView.findViewById(R.id.placeholderAlbum);
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
