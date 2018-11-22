package com.example.geyik.termproject.ViewHolders;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.android.welyre.R;
import com.example.geyik.termproject.ActivityLyricDisplay;
import com.example.geyik.termproject.ActivitySearchResults;

import org.json.JSONObject;

public class DataSong extends DataProj {
    TextView placeholder;

    public DataSong(@NonNull View itemView, final ActivitySearchResults rV) {
        super(itemView, rV);

        placeholder = itemView.findViewById(R.id.placeholderSong);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lyricCaller = new Intent(parent, ActivityLyricDisplay.class);
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
