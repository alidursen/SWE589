package com.example.geyik.termproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.android.welyre.R;

import org.json.JSONArray;
import org.json.JSONException;

public class SearchBehaviour extends AppCompatActivity {



    private AdapterProj adapter;
    private RecyclerView searchResult;
    private Intent starter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        starter = getIntent();
        setContentView(R.layout.search_result);

        searchResult = findViewById(R.id.searchResult);

        updateAdapter(starter.getStringArrayExtra(Intent.EXTRA_TEXT)[0],
                starter.getStringArrayExtra(Intent.EXTRA_TEXT)[1]);
    }

    public void updateAdapter(String adapterName, String query){
        try {
            switch (adapterName){
                case "artist":
                    adapter = new AdapterArtist(query, SearchBehaviour.this);
                    break;
                case "album":
                    adapter = new AdapterAlbum(query, SearchBehaviour.this);
                    break;
                case "song":
                    adapter = new AdapterSong(query, SearchBehaviour.this);
                    break;
            }
        } catch (JSONException e) { e.printStackTrace(); }
        searchResult.setAdapter(adapter);
    }
}
