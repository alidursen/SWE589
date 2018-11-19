package com.example.geyik.termproject;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.android.welyre.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent searchStarter = new Intent(MainActivity.this, SearchBehaviour.class);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        final EditText searchArtist = findViewById(R.id.editText1);
        final EditText searchAlbum = findViewById(R.id.editText2);
        final EditText searchSong = findViewById(R.id.editText3);
        Button buttonArtist = findViewById(R.id.button1);
        Button buttonAlbum = findViewById(R.id.button2);
        Button buttonSong = findViewById(R.id.button3);

        searchArtist.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    String[] s = {"artist", v.getText().toString()};
                    searchStarter.putExtra(Intent.EXTRA_TEXT, s);
                    startActivity(searchStarter);
                    return true;
                }
                return false;
            }
        });

        searchAlbum.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    String[] s = {"album", v.getText().toString()};
                    searchStarter.putExtra(Intent.EXTRA_TEXT, s);
                    startActivity(searchStarter);
                    return true;
                }
                return false;
            }
        });

        searchSong.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    String[] s = {"song", v.getText().toString()};
                    searchStarter.putExtra(Intent.EXTRA_TEXT, s);
                    startActivity(searchStarter);
                    return true;
                }
                return false;
            }
        });

        buttonArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] s = {"artist", searchArtist.getText().toString()};
                searchStarter.putExtra(Intent.EXTRA_TEXT, s);
                startActivity(searchStarter);
            }
        });

        buttonAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] s = {"album", searchAlbum.getText().toString()};
                searchStarter.putExtra(Intent.EXTRA_TEXT, s);
                startActivity(searchStarter);
            }
        });

        buttonSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] s = {"song", searchSong.getText().toString()};
                searchStarter.putExtra(Intent.EXTRA_TEXT, s);
                startActivity(searchStarter);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }



}
