package com.example.geyik.mobiledevmidterm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        String[] HARD_CODED = {"string1", "dont know", "what to write",
            "let this", "be a form of", "self-expression", "wowzers",
            "this may", "very well be", "my worst poem", "ever"};

        RecyclerView rV = findViewById(R.id.recyclerMain);
        rV.setLayoutManager(new LinearLayoutManager(this));
        rV.setHasFixedSize(true);
        final Adapter1 adapter1 = new Adapter1(HARD_CODED, HARD_CODED.length);
        rV.setAdapter(adapter1);

        String acronym = "EU";
        adapter1.setData(ObtainTheList(acronym));

        EditText editText = findViewById(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    adapter1.setData(ObtainTheList(v.getText().toString()));
                    handled = true;
                }
                return handled;
            }
        });

    }

    public String[] ObtainTheList(String ofWhat){
        GetAcronym getAcronym = new GetAcronym(ofWhat);
        getAcronym.execute();
        JSONArray acryData;
        String[] acryonymStr;
        try {
            acryData = getAcronym.get();
            acryData = (acryData.getJSONObject(0)).getJSONArray("lfs");
            int i = acryData.length();
            acryonymStr = new String[i];

            for(int j=0; j<i; j++){
                String prefStr = PreferenceManager.getDefaultSharedPreferencesName(this);
                String lf="";
                String since="";
                if(prefStr=="base"){
                    lf = (acryData.getJSONObject(j)).getString("lf");
                    since = (acryData.getJSONObject(j)).getString("since");
                } else{
                    if (prefStr=="new"){
                        JSONArray jsonArray = (acryData.getJSONObject(j)).getJSONArray("vars");
                        int newest=0;
                        int loc = 0;
                        for(int i1=0; i<jsonArray.length(); i1++){
                            if((jsonArray.getJSONObject(i1)).getInt("since") > newest){
                                newest = (jsonArray.getJSONObject(i1)).getInt("since");
                                loc = i1;
                            }
                        }
                        JSONObject jsonObject = jsonArray.getJSONObject(loc);
                        lf = jsonObject.getString("lf");
                        since = jsonObject.getString("since");
                    }
                }
                acryonymStr[j] = "("+since+"), " + lf;
            }

            return acryonymStr;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
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
