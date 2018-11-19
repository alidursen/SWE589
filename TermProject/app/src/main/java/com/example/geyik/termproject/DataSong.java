package com.example.geyik.termproject;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.android.welyre.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataSong extends DataProj {
    TextView placeholder;

    public DataSong(@NonNull View itemView, final SearchBehaviour rV) {
        super(itemView, rV);

        placeholder = itemView.findViewById(R.id.placeholderSong);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lyricCaller = new Intent(parent, LyricDisplay.class);
                lyricCaller.putExtra(Intent.EXTRA_TEXT, getQuery());
                parent.startActivity(lyricCaller);
            }
        });
    }

    @Override
    public String getQuery() {
        return null;
    }

    @Override
    public void bind(JSONObject obj) {
        placeholder.setText(obj.toString());
    }
}
