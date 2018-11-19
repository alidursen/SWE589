package com.example.geyik.termproject;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.android.welyre.R;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class DataArtist extends DataProj {
    TextView placeholder;

    public DataArtist(@NonNull View itemView, SearchBehaviour rV) {
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
